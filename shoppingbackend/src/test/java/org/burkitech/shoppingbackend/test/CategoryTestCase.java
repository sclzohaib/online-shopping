package org.burkitech.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.burkitech.shoppingbackend.dao.CategoryDAO;
import org.burkitech.shoppingbackend.dto.Category;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static CategoryDAO categoryDAO;
	private Category category;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("org.burkitech.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

	@Test
	public void testAddCategory() {
		category = new Category();
		category.setDescription("Description for food");
		category.setImageURL("slider1.png");
		category.setName("Food");
		assertEquals("Successfully fetched", true, categoryDAO.add(category));
	}

	// @Test
	// public void testGetCategory(){
	// category=categoryDAO.get(3);
	// assertEquals("Successfully fetched","Mobile",category.getName());
	// }

	// @Test
	// public void testUpdateCategory(){
	// category=categoryDAO.get(3);
	// category.setName("MBL");
	// assertEquals("Successfully updated",true,categoryDAO.update(category));
	// }

	// @Test
	// public void testDeleteCategory(){
	// category=categoryDAO.get(3);
	// assertEquals("Successfully deleted",true,categoryDAO.delete(category));
	// }

	// @Test
	// public void testListCategory(){
	// assertEquals("Successfully deleted",3,categoryDAO.categoryList());
	// }

	// @Test
	// public void testCRUDCategory(){
	// category=new Category();
	// }
}
