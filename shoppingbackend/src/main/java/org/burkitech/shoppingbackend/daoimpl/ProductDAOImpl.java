package org.burkitech.shoppingbackend.daoimpl;

import java.util.List;

import org.burkitech.shoppingbackend.dao.ProductDAO;
import org.burkitech.shoppingbackend.dto.Category;
import org.burkitech.shoppingbackend.dto.Product;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("categoryDAO")
public class ProductDAOImpl implements ProductDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Product get(int id) {
		return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(id));
	}

	@Override
	public List<Product> productList() {
		// use entity name
				String selectActiveCategory = "FROM Product WHERE active = :active";
				Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
				query.setParameter("active", 'Y');
				return query.getResultList();
	}

	@Override
	public boolean add(Product product) {
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		}

		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		}

		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Product product) {
		try {
			sessionFactory.getCurrentSession().delete(product);
			return true;
		}

		catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProducts="FROM Product WHERE active=:active";
		return sessionFactory.getCurrentSession().
		createQuery(selectActiveProducts,Product.class)
		.setParameter("active",true)
		.getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectActiveProductsByCategory="FROM Product WHERE active=:active AND categoryID=:categoryID";
		return sessionFactory.getCurrentSession().
		createQuery(selectActiveProductsByCategory,Product.class)
		.setParameter("active",true)
		.setParameter("categoryId", categoryId)
		.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		String selectLatestProducts="FROM Product WHERE active=:active order by id";
		return sessionFactory.getCurrentSession().
		createQuery(selectLatestProducts,Product.class)
		.setParameter("active",true)
		.setFirstResult(0)
		.setMaxResults(count)
		.getResultList();
	}

}
