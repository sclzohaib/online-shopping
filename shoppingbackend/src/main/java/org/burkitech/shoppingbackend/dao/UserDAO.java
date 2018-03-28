package org.burkitech.shoppingbackend.dao;

import java.util.List;

import org.burkitech.shoppingbackend.dto.Address;
import org.burkitech.shoppingbackend.dto.Cart;
import org.burkitech.shoppingbackend.dto.User;

public interface UserDAO {
	// Add a User
	boolean addUser(User user);

	// Add an address
	boolean addAddress(Address address);

	// Add a cart
	boolean addCart(Cart cart);

	int getMaxId();
}
