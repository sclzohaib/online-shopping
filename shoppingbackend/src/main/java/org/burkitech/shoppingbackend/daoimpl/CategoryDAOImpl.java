package org.burkitech.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.burkitech.shoppingbackend.dao.CategoryDAO;
import org.burkitech.shoppingbackend.dto.Category;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	static List<Category> categoryList = new ArrayList<>();
	static {
		Category category = new Category();
		category.setId(1);
		category.setName("Food");
		category.setDescription("Description for food");
		category.setImageURL("slider1.png");
		categoryList.add(category);

		category = new Category();
		category.setId(2);
		category.setName("Coffee");
		category.setDescription("Description for coffee");
		category.setImageURL("slider2.png");
		categoryList.add(category);

		category = new Category();
		category.setId(3);
		category.setName("Mobile");
		category.setDescription("Description for mobile");
		category.setImageURL("slider3.png");
		categoryList.add(category);

	}

	@Override
	public List<Category> categoryList() {
		return categoryList;
	}

	@Override
	public Category get(int id) {
		for (Category category : categoryList) {
			if (category.getId() == id)
				return category;
		}
		return null;
	}

	@Override
	@Transactional
	public boolean add(Category category) {
		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}

		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

}
