package org.burkitech.onlineshopping.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.burkitech.onlineshopping.util.FileUploadUtility;
import org.burkitech.onlineshopping.validator.ProductValidator;
import org.burkitech.shoppingbackend.dao.EmployeeDAO;
import org.burkitech.shoppingbackend.dao.ProductDAO;
import org.burkitech.shoppingbackend.dto.Employee;
import org.burkitech.shoppingbackend.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	@RequestMapping("/menifest")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Menifest");
		mv.addObject("userClickMenifest", true);
		return mv;
	}

	@RequestMapping("/delivery")
	public ModelAndView delivery() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Delivery");
		mv.addObject("userClickDelivery", true);
		return mv;
	}

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public ModelAndView employee() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "Employee");
		mv.addObject("userClickEmployee", true);
		return mv;
	}
	
	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public String hanldeEmployee(@Valid @ModelAttribute("employee") Employee mEmployee, BindingResult results,
			Model model, HttpServletRequest request) {
		model.addAttribute("employee",new Employee());
		if(mEmployee.getId()==0) {
			new ProductValidator().validate(mEmployee,results);
			}
		// check if there is any error
				System.out.println(results);
				if (results.hasErrors()) {
					model.addAttribute("userClickEmployee", true);
					model.addAttribute("title", "Employee");
					return "page";
				}	
				if(mEmployee.getId()==0) {
					// create a new record of product
					employeeDAO.add(mEmployee);	
				}
				else {
					// update existing product if id is not 0
					employeeDAO.update(mEmployee);
				}
		return "redirect:/employee?operation=employee";
	}
}
