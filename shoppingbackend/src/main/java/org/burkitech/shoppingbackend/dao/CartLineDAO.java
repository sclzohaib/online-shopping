package org.burkitech.shoppingbackend.dao;

import java.util.List;

import org.burkitech.shoppingbackend.dto.Cart;
import org.burkitech.shoppingbackend.dto.CartLine;

public interface CartLineDAO {

public CartLine get(int id);
public boolean add(CartLine cartLine);
public boolean update(CartLine cartLine);
public boolean delete(CartLine cartLine);
public List<CartLine> list(int cartId);

//other business method related to the cart lines
public List<CartLine> listAvailable(int cartId);
public CartLine getByCartAndProduct(int cartId, int productId);
// Update a cart
boolean updateCart(Cart cart);
}
