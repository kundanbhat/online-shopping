package net.kzn.onlineshopping.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import net.kzm.shoppingbackend.dao.CategoryDAO;
import net.kzm.shoppingbackend.dao.ProductDAO;
import net.kzm.shoppingbackend.dto.Category;
import net.kzm.shoppingbackend.dto.Product;
import net.kzn.onlineshopping.exception.ProductNotFoundException;

@Controller
public class PageController {

	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value= {"/","/home","/index"})
	public String index(Model model)
	{
		model.addAttribute("title","Home Page");
		model.addAttribute("userClickHome",true);
		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method - DEBUG");
		model.addAttribute("categories",categoryDAO.list());
		return "page";
	}
	
	@RequestMapping(value= {"/about"})
	public String about(Model model)
	{
		model.addAttribute("title","About Us");
		model.addAttribute("userClickAbout",true);
		return "page";
	}
	
	@RequestMapping(value= {"/contact"})
	public String contact(Model model)
	{
		model.addAttribute("title","Contact Us");
		model.addAttribute("userClickContact",true);
		return "page";
	}
	
	@RequestMapping(value= {"/show/all/products"})
	public String showAllProducts(Model model)
	{
		model.addAttribute("title","All Products");
		model.addAttribute("userClickAllProducts",true);
		model.addAttribute("categories",categoryDAO.list());
		return "page";
	}
	
	@RequestMapping(value= {"/show/category/{id}/products"})
	public String showCategoryProducts(@PathVariable("id") int id,  Model model)
	{
		
		Category category=categoryDAO.get(id);
		
		model.addAttribute("title",category.getName());
		model.addAttribute("userClickCategoryProducts",true);
		model.addAttribute("categories",categoryDAO.list());
		model.addAttribute("category",category);
		return "page";
	}
	
	@RequestMapping(value="/show/{id}/product")
	public String showSingleProduct(@PathVariable("id") int id,Model model) throws ProductNotFoundException {
		Product product=productDAO.get(id);
		if(product==null) {throw new ProductNotFoundException();}
		product.setViews(product.getViews()+1);
		productDAO.update(product);
		model.addAttribute("title", product.getName());
		model.addAttribute("product", product);
		model.addAttribute("userClickShowProduct",true);	
		return "page";
	}
	
	
}
