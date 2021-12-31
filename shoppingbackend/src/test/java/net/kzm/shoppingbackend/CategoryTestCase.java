package net.kzm.shoppingbackend;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzm.shoppingbackend.dao.CategoryDAO;
import net.kzm.shoppingbackend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	
	
	@BeforeClass
	public static void init()
	{
		context=new AnnotationConfigApplicationContext();
		context.scan("net.kzm.shoppingbackend");
		context.refresh();
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
	
	@Test
	public void addTestCategory() {
		Category category=new Category();
		category.setActive(true);
		category.setDescription("This is Mobile description");
		category.setName("Mobile");
		category.setImageURL("CAT_3.png");
		
		assertEquals("successfully added", true, categoryDAO.add(category));
		
	}
	
//	@Test
//	public void getCategory() {
//		
//		Category category=categoryDAO.get(1);
//		assertEquals("Successfully fetch category", "Laptop", category.getName());
//		
//	}
	
//	@Test
//	public void updateCategory() {
//		
//		Category category=categoryDAO.get(1);
//		category.setName("Mobile");
//		categoryDAO.updateCategory(category);
//		category=categoryDAO.get(1);
//		assertEquals("Successfully fetch category", "Mobile", category.getName());
//		
//	}
	
	
	

}
