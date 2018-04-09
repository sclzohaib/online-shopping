package org.burkitech.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.burkitech.shoppingbackend.dao.CartLineDAO;
import org.burkitech.shoppingbackend.dao.ProductDAO;
import org.burkitech.shoppingbackend.dao.UserDAO;
import org.burkitech.shoppingbackend.dto.Cart;
import org.burkitech.shoppingbackend.dto.CartLine;
import org.burkitech.shoppingbackend.dto.Product;
import org.burkitech.shoppingbackend.dto.User;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CartLineTestCase {

	private static AnnotationConfigApplicationContext context;
	private static CartLineDAO cartLineDAO = null;
	private static ProductDAO productDAO = null;
	private static UserDAO userDAO = null;
	private Product product = null;
	private User user = null;
	private Cart cart = null;
	private CartLine cartLine = null;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("org.burkitech.shoppingbackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
		userDAO = (UserDAO) context.getBean("userDAO");
		cartLineDAO = (CartLineDAO) context.getBean("cartLineDAO");
	}

	@Test
	public void testAddNewCartLine() {

		// 1.get the user
		user = userDAO.getByEmail("shaista.raees@gmail.com");
		// 2.fetch the cart
		cart = user.getCart();
		// 3. get the product
		product = productDAO.get(1);
		// 4. create a new cartline
		cartLine = new CartLine();
		cartLine.setBuyingPrice(product.getUnitPrice());
		cartLine.setProductCount(cartLine.getProductCount() + 1);
		cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());
		cartLine.setAvailable('Y');
		cartLine.setCartId(cart.getId());
		cartLine.setProduct(product);
		assertEquals("failed to add Cartline", true, cartLineDAO.add(cartLine));
		
		// UPDATE THE CART
		cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
		cart.setCartLines(cart.getCartLines() + 1);
		assertEquals("failed to update Cart", true, cartLineDAO.updateCart(cart));

	}
}
