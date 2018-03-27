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

		}
		return mv;

	}

	//handling product 
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute("product") Product mProduct, BindingResult results,
			Model model, HttpServletRequest request) {
		
		new ProductValidator().validate(mProduct,results);
		

		// check if there is any error
		System.out.println(results);
		if (results.hasErrors()) {
			model.addAttribute("userClickManageProducts", true);
			model.addAttribute("title", "Manage Products");

			return "page";
		}

		logger.info(mProduct.toString());

		// create a new record of product
		productDAO.add(mProduct);

		if (!mProduct.getFile().getOriginalFilename().equals("")) {

			FileUploadUtility.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}

		return "redirect:/manage/products?operation=product";
	}

	// returning categories for all request mapping
	@ModelAttribute("categories")
	public List<Category> getCategories() {
		return categoryDAO.categoryList();
	}

}
