package net.kzn.onlineshopping.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@RequestMapping(value= {"/","/home","/index"})
	public String index(Model model)
	{
		model.addAttribute("greetings","welcome to spring web MVC");
		return "page";
	}
	
	
}
