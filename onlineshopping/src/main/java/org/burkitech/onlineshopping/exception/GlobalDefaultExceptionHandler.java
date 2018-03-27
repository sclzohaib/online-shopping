package org.burkitech.onlineshopping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException(){
	ModelAndView mv =new ModelAndView("error");
	mv.addObject("errorTitle","Page is not constructed");
	mv.addObject("errorDescription","The page you are loading is not available!");
	mv.addObject("title","404 Error Page");
	return mv;
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException(){
	ModelAndView mv =new ModelAndView("error");
	mv.addObject("errorTitle","Product not available");
	mv.addObject("errorDescription","The Product you are looking for is not available right now!");
	mv.addObject("title","Product unavailable");
	return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex){
	ModelAndView mv =new ModelAndView("error");
	mv.addObject("errorTitle","Contact your administrator");
	
//	only for debuggind your application
	StringWriter sw=new StringWriter();
	PrintWriter pw= new PrintWriter(sw);
	ex.printStackTrace(pw);
	
	mv.addObject("errorDescription",sw.toString());
	mv.addObject("title","Error");
	return mv;
	}
}
