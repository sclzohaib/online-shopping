package org.burkitech.onlineshopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.burkitech.onlineshopping.util.FileUploadUtility;
import org.burkitech.onlineshopping.validator.ProductValidator;
import org.burkitech.shoppingbackend.dao.CategoryDAO;
import org.burkitech.shoppingbackend.dao.ProductDAO;
import org.burkitech.shoppingbackend.dto.Category;
import org.burkitech.shoppingbackend.dto.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manage")
public class ManagementController {

	@Autowired
	private CategoryDAO categoryDAO;
	@Autowired
	private ProductDAO productDAO;
	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);
	//---------------------------------------------------------------------------------
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView showManageProducts(@RequestParam(name = "operation", required = false) String operation) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		Product nProduct = new Product();
		nProduct.setActive('Y');
		mv.addObject("product", nProduct);

		if (operation != null) {
			if (operation.equals("product")) {

				mv.addObject("message", "Product submitted successfully!");
			}
			else if (operation.equals("category")) {

				mv.addObject("message", "Category submitted successfully!");
			}
		}
		return mv;
	}
	//---------------------------------------------------------------------------------
	@RequestMapping(value="/{id}/product",method=RequestMethod.GET)
	public ModelAndView showEditProducts(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("userClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		//fetch product from the database		
		Product nProduct = productDAO.get(id);
		mv.addObject("product", nProduct); 
		return mv;
	}
	//---------------------------------------------------------------------------------
	//handling product 
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult results,
			Model model, HttpServletRequest request) {		
		if(mProduct.getId()==0) {
		new ProductValidator().validate(mProduct,results);
		}
		else {
			if(!mProduct.getFile().getOriginalFilename().equals("")) {
				new ProductValidator().validate(mProduct,results);
			}
		}
		// check if there is any error
		System.out.println(results);
		if (results.hasErrors()) {
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Products");
			return "page";
		}
		logger.info(mProduct.toString());	
		if(mProduct.getId()==0) {
			// create a new record of product
			productDAO.add(mProduct);	
		}
		else {
			// update existing product if id is not 0
			productDAO.update(mProduct);
		}	
		if (!mProduct.getFile().getOriginalFilename().equals("")) {
			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}
		return "redirect:/manage/products?operation=product";
	}
	//---------------------------------------------------------------------------------
	//handling catgory
	@RequestMapping(value= "/category" ,method=RequestMethod.POST)
	public String HandleCategorySubmission(@ModelAttribute Category category) {
		categoryDAO.add(category);		
		return "redirect:/manage/products?operation=category";
	}
	//---------------------------------------------------------------------------------
	// returning categories for all request mapping
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryDAO.categoryList();
	}
	@ModelAttribute("category")
	public Category getCategory() {
		return new Category();
	}
}
