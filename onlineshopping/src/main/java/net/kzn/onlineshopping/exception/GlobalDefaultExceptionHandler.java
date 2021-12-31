package net.kzn.onlineshopping.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public String handleNoHandlerFoundException(Model model) {
		model.addAttribute("errorTitle", "The page is not constructed");
		model.addAttribute("errorDescription", "The page you are looking for is not  available");
		model.addAttribute("title", "404 Error Page");
		return "error";
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public String handleProductNotFoundException( Model model) {
      	model.addAttribute("errorTitle", "product  not available");
		model.addAttribute("errorDescription", "The product  you are looking for is not  available");
		model.addAttribute("title", "Product unavaiable");
		return "error";
	}
	
	@ExceptionHandler(Exception.class)
	public String handleException(Exception ex,Model model) {
      	model.addAttribute("errorTitle", "contact your administrator");
		model.addAttribute("errorDescription",ex.toString());
		model.addAttribute("title", "error");
		return "error";
	}
	
	
	

}
