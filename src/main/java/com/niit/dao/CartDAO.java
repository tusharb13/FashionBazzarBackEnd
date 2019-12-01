package com.niit.dao;

import java.util.List;

import com.niit.model.Cart;

public interface CartDAO {
	
	public boolean addToCart(Cart cartItem);
	public boolean deleteCartItem(Cart cartItem);
	public boolean updateCartItem(Cart cartItem);
	public List<Cart> listCartItems(String username);
	public Cart getcartItem(int cartItemId);

}
