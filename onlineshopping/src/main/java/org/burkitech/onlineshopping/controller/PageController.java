package org.burkitech.onlineshopping.controller;

import org.burkitech.onlineshopping.exception.ProductNotFoundException;
import org.burkitech.shoppingbackend.dao.CategoryDAO;
import org.burkitech.shoppingbackend.dao.ProductDAO;
import org.burkitech.shoppingbackend.dto.Category;
import org.burkitech.shoppingbackend.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	
	@Autowired	
	private CategoryDAO categoryDAO;
	
	@Autowired	
	private ProductDAO productDAO;
	
	
@RequestMapping(value = {"/","/home","/index"})
public ModelAndView index() {
	
	ModelAndView mv = new ModelAndView("page");
	mv.addObject("title", "Home");
	System.out.println("wahaj");
	//categories fetching
	mv.addObject("categories",categoryDAO.categoryList());
	
	mv.addObject("userClickHome", true);
	return mv;
	
}

@RequestMapping(value = "/about")
public ModelAndView about() {
	
	ModelAndView mv = new ModelAndView("page");
	mv.addObject("title", "About Us");
	mv.addObject("userClickAbout", true);
	return mv;
	
}

@RequestMapping(value = "/contact")
public ModelAndView contact() {
	
	ModelAndView mv = new ModelAndView("page");
	mv.addObject("title", "Contact Us");
	mv.addObject("userClickContact", true);
	return mv;
	
}

@RequestMapping(value = "/show/all/products")
public ModelAndView showAllProducts() {	
	ModelAndView mv = new ModelAndView("page");
	mv.addObject("title", "All Products");
	mv.addObject("categories",categoryDAO.categoryList());
	mv.addObject("userClickAllProducts", true);
	return mv;
	
}

@RequestMapping(value = "/show/category/{id}/products")
public ModelAndView showCategoryProducts(@PathVariable("id") int id) {	
	ModelAndView mv = new ModelAndView("page");
	Category category= null;
	category=categoryDAO.get(id);
	mv.addObject("title", category.getName());
	mv.addObject("categories",categoryDAO.categoryList());
	mv.addObject("category",category);
	mv.addObject("userClickCategoryProducts", true);
	return mv;
	
}

@RequestMapping (value = "/show/{id}/product")
public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException{

  ModelAndView mv = new ModelAndView("page");
  Product product = productDAO.get(id);
  
  if(product==null) throw new ProductNotFoundException();
  
  //update the view count
  product.setViews(product.getViews()+1);
  productDAO.update(product);
  
  mv.addObject("title",product.getName());
  mv.addObject("product",product);
  
  mv.addObject("userClickShowProduct",true);
 

  return mv;

}
}

//@RequestMapping(value = {"/test"})
//public ModelAndView test(@RequestParam(value = "greeting", required = false) String greeting) {
//	if(greeting==null) {
//		greeting="Hello world";
//		
//	}
//	ModelAndView mv = new ModelAndView("page");
//	mv.addObject("greeting", greeting);
//	return mv;
//	
//}
//---------------------------------------------------------------------
//@RequestMapping(value = {"/test/{var}"})
//public ModelAndView test(@PathVariable("var") String greeting) {
//	if(greeting==null) {
//		greeting="Hello world";
//		
//	}
//	ModelAndView mv = new ModelAndView("page");
//	mv.addObject("greeting", greeting);
//	return mv;
//	
//}

