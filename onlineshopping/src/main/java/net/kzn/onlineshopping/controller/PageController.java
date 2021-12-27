package net.kzn.onlineshopping.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import net.kzm.shoppingbackend.dao.CategoryDAO;
import net.kzm.shoppingbackend.dto.Category;

@Controller
public class PageController {

	@Autowired
	private CategoryDAO categoryDAO;
	
	
	@RequestMapping(value= {"/","/home","/index"})
	public String index(Model model)
	{
		model.addAttribute("title","Home Page");
		model.addAttribute("userClickHome",true);
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
	
	
}
