package net.kzm.shoppingbackend.daoimpl;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzm.shoppingbackend.dao.CategoryDAO;
import net.kzm.shoppingbackend.dto.Category;


@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
	    Session session=sessionFactory.getCurrentSession();
	    Query<Category> query=session.createQuery("from Category",Category.class);
	    return query.getResultList();
	    
	}



	@Override
	public Category get(int id) {
		
		Category category=sessionFactory.getCurrentSession().get(Category.class, id);
		return category;
	}



	@Override
	public boolean add(Category category) {
		// TODO Auto-generated method stub
		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
		
	}



	@Override
	public boolean updateCategory(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}



	@Override
	public boolean deleteCategory(Category category) {
		// TODO Auto-generated method stub
		return false;
	}

}
