package com.niit.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.SystemPropertyUtils;


import com.niit.dao.ProductDAO;
import com.niit.model.Category;
import com.niit.model.Product;

public class ProductDAOTest {
	
static ProductDAO productDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	
	@Test
	@Ignore
	public void addProductTest()
	{
		Product product = new Product();
		product.setProductName("J8");
		product.setProductDesc("New in market");
		product.setPrice(10000);
		product.setStock(10);
		product.setCategoryId(1);
		product.setSupplierId(2);
		assertTrue("Could'nt add product",productDAO.addProduct(product));
	}
	
	@Test
	@Ignore
	public void deleteProductTest()
	{
		Product product = productDAO.getProduct(4);
		assertTrue("Could'nt delete product",productDAO.deleteProduct(product));
	}
	
	@Test
	@Ignore
	public void updateProductTest()
	{
		Product product = productDAO.getProduct(5);
		assertTrue("Product not Found",product!=null);
		product.setPrice(1999);
		assertTrue("Could'nt update product",productDAO.updateProduct(product));
					
	}
	
	@Test
	@Ignore
	public void getProductTest()
	{
		Product product = productDAO.getProduct(4);
		assertTrue("Could'nt find product",product!=null);
		System.out.println(product.getProductName());
	}
	
	@Test
	@Ignore
	public void listProductsTest()
	{
		List<Product> listProducts = productDAO.listProducts();
		assertTrue("Could'nt list products", listProducts.size()>0);
		for(Product product:listProducts){
			System.out.println(product.getProductName());
		}
	}
	@Test
	@Ignore
	public void listProductsByCategoryTest(){
		List<Product> listProductsByCategory = productDAO.listProductsByCategory(1);
		assertTrue("Could'nt list products", listProductsByCategory.size()>0);
		for(Product product:listProductsByCategory){
			System.out.println(product.getProductName());
		}
	}
	
	@Test
	@Ignore
	public void listProductsBySupplier()
	{
		List<Product> listProductsBySupplier = productDAO.listProductsBySupplier(2);
		assertTrue("Could'nt list products", listProductsBySupplier.size()>0);
		for(Product product:listProductsBySupplier){
			System.out.println(product.getProductName());
			System.out.println(product.getProductDesc());
		}
	}
}
	