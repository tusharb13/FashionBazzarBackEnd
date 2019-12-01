package com.niit.dao;

import java.util.List;

import com.niit.model.Product;

public interface ProductDAO {
	public boolean addProduct(Product product);
	public boolean deleteProduct(Product product);
	public boolean updateProduct(Product product);
	public Product getProduct(int productId);
	public List<Product> listProducts();
	public List<Product> listProductsByCategory(int categoryId);
	public List<Product> listProductsBySupplier(int supplierId);
	
}