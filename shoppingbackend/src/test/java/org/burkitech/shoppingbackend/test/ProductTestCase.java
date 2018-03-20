package org.burkitech.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.burkitech.shoppingbackend.dao.ProductDAO;
import org.burkitech.shoppingbackend.dto.Product;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductTestCase {
	private static AnnotationConfigApplicationContext context;
	
	@Autowired
	private static ProductDAO productDAO;
	private Product product;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("org.burkitech.shoppingbackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
	}
	
//	@Test
//	public void testCRUDProduct(){
//	product = new Product();
//	product.setName("Oppo Selfie S53");
//	product.setBrand("Oppo");
//	product.setDescription("Description about oppo");
//	product.setUnitPrice(25000);
//	product.setActive('Y');
//	product.setCategoryId(2);
////	product.setSupplierId(3);
//	assertEquals("Something went wrong while inserting a new product!",
//	true,productDAO.add(product));

	//reading and updating the category
//	product=productDAO.get(2);
//	product.setName("Samsung Galaxy S7");
//	assertEquals("Something went wrong while updating the existing record!",
//	true,productDAO.update(product));
//
//	assertEquals("Something went wrong while deleting the existing record!",
//	true,productDAO.delete(product));
//
//	assertEquals("Something went wrong while fetching the existing record!",
//	6,productDAO.productList().size());
//	}
	
	@Test
	public void testListActiveProducts(){
	assertEquals("Something went wrong while fetching the list of products!",
	3,productDAO.listActiveProducts().size());
	}

//	@Test
//	public void testListActiveProductsByCategory(){
//	assertEquals("Something went wrong while fetching the list of products!",
//	3,productDAO.listActiveProductsByCategory(3).size());
//	assertEquals("Something went wrong while fetching the list of products!",
//	2,productDAO.listActiveProductsByCategory(1).size());
//	}
//
//	@Test
//	public void testGetLatestActiveProduct(){
//	assertEquals("Something went wrong while fetching the list of products!",
//	3,productDAO.getLatestActiveProducts(3).size());
//	}

}
