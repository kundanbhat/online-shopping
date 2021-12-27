package net.kzm.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.kzm.shoppingbackend.dao.CategoryDAO;
import net.kzm.shoppingbackend.dto.Category;


@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	private static List<Category> categories=new ArrayList<Category>();
	
	static {
		Category category=new Category();
		category.setActive(true);
		category.setDescription("This is Television description");
		category.setId(1);
		category.setName("Television");
		category.setImageURL("CAT_1.png");
		categories.add(category);
		
		category=new Category();
		category.setActive(true);
		category.setDescription("This is Laptop description");
		category.setId(2);
		category.setName("Laptop");
		category.setImageURL("CAT_2.png");
		categories.add(category);
		
		
		category=new Category();
		category.setActive(true);
		category.setDescription("This is Mobile description");
		category.setId(3);
		category.setName("Mobile");
		category.setImageURL("CAT_3.png");
		categories.add(category);
		
	}
	
	
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}



	@Override
	public Category get(int id) {
		// TODO Auto-generated method stub
		for(Category category:categories)
		{
			if(category.getId()==id)
				return category;
		}
		return null;
	}

}
