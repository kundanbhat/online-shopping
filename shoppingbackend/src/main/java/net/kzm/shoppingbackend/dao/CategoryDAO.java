package net.kzm.shoppingbackend.dao;

import java.util.List;

import net.kzm.shoppingbackend.dto.Category;

public interface CategoryDAO {
	
	public List<Category> list();
	public Category get(int id);

}
