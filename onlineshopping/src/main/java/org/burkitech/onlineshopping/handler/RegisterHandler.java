package org.burkitech.onlineshopping.handler;

import org.burkitech.onlineshopping.model.RegisterModel;
import org.burkitech.shoppingbackend.dao.UserDAO;
import org.burkitech.shoppingbackend.dto.Address;
import org.burkitech.shoppingbackend.dto.Cart;
import org.burkitech.shoppingbackend.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterHandler {

	private static final char Boolean = 0;
	@Autowired

	private UserDAO userDAO;

	public RegisterModel init() {
		return new RegisterModel();
	}

	public void addUser(RegisterModel registerModel, User user) {
		System.out.println("addUser");
		registerModel.setUser(user);
	}

	public void addBilling(RegisterModel registerModel, Address billing) {
		System.out.println("addBilling");
		registerModel.setBilling(billing);
	}

	public String saveAll(RegisterModel model) {
		String transitionValue = "success";
		// fetch the user
		System.out.println("saveAll");
		User user = model.getUser();
		if (user.getRole().equals("USER")) {
			Cart cart = new Cart();

			// cart.getUser().setId(152);
			user.setId((userDAO.getMaxId()) + 1);
			cart.setUser(user);

			user.setCart(cart);
		}

		// SAVE the user
		System.out.println("SAVE the user");
		userDAO.addUser(user);
		// get the address
		System.out.println("get address");
		Address billing = model.getBilling();
		billing.setUserId(user.getId());
		billing.setBilling('Y');
		// save the address
		System.out.println("add address");
		userDAO.addAddress(billing);
		return transitionValue;
	}
}
