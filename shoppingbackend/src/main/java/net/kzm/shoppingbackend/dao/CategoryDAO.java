package net.kzm.shoppingbackend.dao;

import java.util.List;

import net.kzm.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	public boolean add(Category category);
	public List<Category> list();
	public Category get(int id);
	public boolean updateCategory(Category category);
	public boolean deleteCategory(Category category);
	

}
