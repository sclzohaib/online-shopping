package org.burkitech.onlineshopping.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.burkitech.onlineshopping.model.UserModel;
import org.burkitech.shoppingbackend.dao.CartLineDAO;
import org.burkitech.shoppingbackend.dao.ProductDAO;
import org.burkitech.shoppingbackend.dto.Cart;
import org.burkitech.shoppingbackend.dto.CartLine;
import org.burkitech.shoppingbackend.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("cartService")
public class CartService {

	@Autowired
	private CartLineDAO cartLineDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private HttpSession session;

	// return the cart of user who has logged in
	private Cart getcart() {
		return ((UserModel) session.getAttribute("userModel")).getCart();
	}

	// returns entrie cartlines
	public List<CartLine> getCartLines() {
		Cart cart = this.getcart();
		return cartLineDAO.list(cart.getId());
	}

	public String updateCartLine(int cartLineId, int count) {	
		//fetch the cart line
		CartLine cartLine = cartLineDAO.get(cartLineId);
		if(cartLine == null){
		  return "result=error";
		}
		else{
			Product product = cartLine.getProduct();
			double oldTotal = cartLine.getTotal();
			//check if product is available
			if(product.getQuantity() <= count){
				count=product.getQuantity();
//				return "result=unavailable";
			}
			cartLine.setProductCount(count);
			cartLine.setBuyingPrice(product.getUnitPrice());
			cartLine.setTotal(product.getUnitPrice() * count);

			cartLineDAO.update(cartLine);
			Cart cart = this.getcart();
			cart.setGrandTotal(cart.getGrandTotal()-oldTotal + cartLine.getTotal());
			cartLineDAO.updateCart(cart);		
		  return "result=updated";
		}	
	}

	public String deleteCartLine(int cartLineId) {
		//fetch the cartline
		CartLine cartLine = cartLineDAO.get(cartLineId);
		if(cartLine == null){
		  return "result=error";
		}
		else{
		  Cart cart = this.getcart();
		  cart.setGrandTotal(cart.getGrandTotal()-cartLine.getTotal());
		  cart.setCartLines(cart.getCartLines()-1);
		  cartLineDAO.updateCart(cart);	  
		  //remove the cart line	  
		  cartLineDAO.delete(cartLine);		  
		  return "result = deleted";
		}
	}

	public String addCartLine(int productId) {
		
		String response = null;
		Cart cart = this.getcart();
		CartLine cartLine = cartLineDAO.getByCartAndProduct(cart.getId(), productId);

		if(cartLine == null){
		//add a new cartLine
		cartLine = new CartLine();
		//fetch the product
		Product product = productDAO.get(productId);
		cartLine.setCartId(cart.getId());
		cartLine.setProduct(product);
		cartLine.setBuyingPrice(product.getUnitPrice());
		cartLine.setProductCount(1);
		cartLine.setTotal(product.getUnitPrice());
		cartLine.setAvailable('Y');
		cartLineDAO.add(cartLine);
		cart.setCartLines(cart.getCartLines() + 1);
		cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
		cartLineDAO.updateCart(cart);
		response = "result = added";	
	}
		else {
			// check if the cartLine has reached the max count
			if(cartLine.getProductCount()<5) {
				//update the productCount for that cartLine
				response=this.updateCartLine(cartLine.getId(),cartLine.getProductCount()+1);
			}
			else {
				response="result=maximum";
			}
		}
		return response;

	}
}
