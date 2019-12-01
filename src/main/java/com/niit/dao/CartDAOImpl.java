package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Cart;
import com.niit.model.Category;

@Repository("cartDAO")
@Transactional
public class CartDAOImpl implements CartDAO {

	@Autowired
	SessionFactory sessionFactory ;
	
	public boolean addToCart(Cart cartItem) {
		try
		{
			sessionFactory.getCurrentSession().save(cartItem);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	public boolean deleteCartItem(Cart cartItem) {
		try
		{
			sessionFactory.getCurrentSession().delete(cartItem);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean updateCartItem(Cart cartItem) {
		try
		{
			sessionFactory.getCurrentSession().update(cartItem);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public List<Cart> listCartItems(String username) {
		try
		{
			Session session= sessionFactory.openSession();
			Query query=session.createQuery("from Cart where username=:uname");
			List<Cart> cartItemList=query.list();
			session.close();
			return cartItemList;
		}
		catch(Exception e)
		{
			return null;
		}
	}

	public Cart getcartItem(int cartItemId) {
		try
		{
			Session session= sessionFactory.openSession();
			Cart cart=(Cart)session.get(Cart.class,cartItemId);
			session.close();
			return cart;
		}
		catch(Exception e)
		{
			return null;
		}
	}

}
