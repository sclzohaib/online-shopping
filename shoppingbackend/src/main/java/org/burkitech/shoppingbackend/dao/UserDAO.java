package org.burkitech.shoppingbackend.dao;

import java.math.BigDecimal;
import java.util.List;

import org.burkitech.shoppingbackend.dto.Address;
import org.burkitech.shoppingbackend.dto.Cart;
import org.burkitech.shoppingbackend.dto.User;

public interface UserDAO {
	// Add a User
	boolean addUser(User user);
	User getByEmail();

	// Add an address
	boolean addAddress(Address address);

	// Update a cart
	boolean updateCart(Cart cart);

	int getMaxId();
}
