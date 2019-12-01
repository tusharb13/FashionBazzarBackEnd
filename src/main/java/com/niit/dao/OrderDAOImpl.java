package com.niit.dao;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.OrderDetail;

@Repository("orderDAO")
@Transactional
public class OrderDAOImpl implements OrderDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	public boolean payment(OrderDetail orderDetail) {
		try {
			sessionFactory.getCurrentSession().save(orderDetail);
			return true;
		}
		catch(Exception e) {
			return false;	
		}
		
	}

	public boolean updatCartItemStatus(String username, int orderId) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query query=session.createQuery("update cart set status='P', orderId =:orderId where username =:username and status='NP'");
		query.setParameter("orderId", orderId);
		query.setParameter("username", username);
		int row_eff = query.executeUpdate();
		if(row_eff > 0) {
			return true;
		}
		else {
			return false;
		}
	}

}
