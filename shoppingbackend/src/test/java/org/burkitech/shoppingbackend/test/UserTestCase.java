
package org.burkitech.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.burkitech.shoppingbackend.dao.UserDAO;
import org.burkitech.shoppingbackend.dto.Address;
import org.burkitech.shoppingbackend.dto.Cart;
import org.burkitech.shoppingbackend.dto.User;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserTestCase {
	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Address address = null;
	private Cart cart = null;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("org.burkitech.shoppingbackend");
		context.refresh();

		userDAO = (UserDAO) context.getBean("userDAO");
	}

//	@Test
//	public void testAdd() {
//		user = new User();
//		user.setFirstName("Mohammad");
//		user.setLastName("Zohaib");
//		user.setEmail("zohaib2@gmail.com");
//		user.setContactNumber("123456789");
//		user.setRole("USER");
//		user.setPassword("123456");
//
//		// Add the user
//		assertEquals("Failed to add user!", true, userDAO.addUser(user));
//		int mId = userDAO.getMaxId();
//		address = new Address();
//		address.setAddressLineOne("A/124, Tariq Road");
//		address.setAddressLineTwo("Near Noorani Kabab");
//		address.setCity("Karachi");
//		address.setState("Sindh");
//		address.setCountry("Pakistan");
//		address.setPostalCode("74505");
//		address.setBilling('Y');
//
//		// Link the user with the address //
//		System.out.println("User id" + userDAO.getMaxId());
//		address.setUserId(mId);
//
//		// add the address
//		assertEquals("Failed to add address!", true, userDAO.addAddress(address));
//
//		if (user.getRole().equals("USER")) {
//			// create a cart for this user
//			cart = new Cart();
//			cart.setCartLines(0);
//			user.setId(mId);
//			cart.setUser(user);
//			System.out.println("ahjahjahah" + cart);
//
//			// add the cart
//			assertEquals("Failed to add cart!", true, userDAO.addCart(cart));
//
//			// add a shipping address for this user
//			address = new Address();
//			address.setAddressLineOne("A/124, Tariq Road");
//			address.setAddressLineTwo("Near Noorani Kabab");
//			address.setCity("Karachi");
//			address.setState("Sindh");
//			address.setCountry("Pakistan");
//			address.setPostalCode("74505");
//			// set shipping to active
//			address.setShipping('Y');
//
//			// link it with the user
//			address.setUserId(mId);
//
//			// add the shipping address
//			assertEquals("Failed to add shipping address!", true, userDAO.addAddress(address));
//		}
//	}

	// @Test
	// public void testAdd() {
	// user = new User();
	// user.setFirstName("Mohammad");
	// user.setLastName("Zohaib");
	// user.setEmail("zohaib1@gmail.com");
	// user.setContactNumber("123456789");
	// user.setRole("USER");
	// user.setPassword("123456");
	//
	// // Add the user
	// // int maxId = userDAO.getMaxId();
	// // System.out.println(maxId);
	//
	// if (user.getRole().equals("USER")) {
	// // create a cart for this user
	// // assertEquals("Failed to add user!", true, userDAO.addUser(user));
	// int mId = (userDAO.getMaxId()) + 1;
	// user.setId(mId);
	// cart = new Cart();
	// cart.setCartLines(0);
	// // user.setId(mId);
	//
	// cart.setUser(user);
	// System.out.println("ahjahjahah" + mId);
	//
	// // attach cart with the user
	// user.setCart(cart);
	// }
	// assertEquals("Failed to add user!", true, userDAO.addUser(user));
	// // assertEquals("Failed to add user!", true, userDAO.addUser(user));
	// // assertEquals("Failed to add user!", true, userDAO.addCart(cart));
	//
	// }

	@Test
	public void testUpdatCart() {

		// fetch the user by its email
		user = userDAO.getByEmail("zohaib@gmail.com");

		// get the cart of the user
		cart = user.getCart();
		cart.setGrandTotal(111);
		cart.setCartLines(3);
		assertEquals("Failed to Update cart!", true, userDAO.updateCart(cart));
	}

}
