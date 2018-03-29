package org.burkitech.shoppingbackend.daoimpl;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.burkitech.shoppingbackend.dao.UserDAO;
import org.burkitech.shoppingbackend.dto.Address;
import org.burkitech.shoppingbackend.dto.Cart;
import org.burkitech.shoppingbackend.dto.User;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("userDAO")
@Transactional
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addUser(User user) {
		try {
			sessionFactory.getCurrentSession().persist(user);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addAddress(Address address) {
		try {
			sessionFactory.getCurrentSession().persist(address);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateCart(Cart cart) {
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public int getMaxId() {
		// String selectId
		// String selectId = "FROM User WHERE id=max(id)";
		// return
		// sessionFactory.getCurrentSession().createQuery(selectId,User.class).getResultList();
		int maxId;
		Object o = (Object) sessionFactory.getCurrentSession().createCriteria(User.class)
				.setProjection(Projections.max("id")).uniqueResult();
		if (o == null) {
			// Query query = sessionFactory.getCurrentSession()
			// .createSQLQuery("SELECT seq_user_detail.CURRVAL as num from dual")
			// .addScalar("num", StandardBasicTypes.INTEGER);
			// maxId = (Integer) query.uniqueResult();
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			BigDecimal commentCount = (BigDecimal) entityManager.createNativeQuery("SELECT user_id_func FROM DUAL")
					.getSingleResult();
			maxId = commentCount.intValue();
			// maxId = (Integer)
			// sessionFactory.getCurrentSession().createCriteria(User.class)
			// .setProjection(Projections.max("id")).uniqueResult();
			return maxId;
		}
		// int maxId = (Integer)
		// sessionFactory.getCurrentSession().createCriteria(User.class)
		// .setProjection(Projections.max("id")).uniqueResult();
		maxId = (Integer) o;
		return maxId;

	}

	@Override
	public User getByEmail(String email) {
		String selectQuery = "FROM User WHERE email = :email";
		try {
			return sessionFactory.getCurrentSession().createQuery(selectQuery, User.class).setParameter("email", email)
					.getSingleResult();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

}
