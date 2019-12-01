package com.niit.test;



import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.SystemPropertyUtils;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;

public class CategoryDAOTest {
	
static CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
	
	@Test
	//@Ignore
	public void addCategoryTest()
	{
		Category category = new Category();
		category.setCategoryName("Clothes1");
		category.setCategoryDesc("cotton clothes1");
		assertTrue("Could'nt set category", categoryDAO.addCategory(category));
		
	}
	
	@Test
	@Ignore
	public void updateCategoryTest()
	{
		Category category = categoryDAO.getCategory(1);
		category.setCategoryName("TV");
		category.setCategoryDesc("Best TV");
		assertTrue("Could'nt update category", categoryDAO.updateCategory(category));
	}
	
	@Test
	@Ignore
	public void deleteCatergoryTest()
	{
		Category category = categoryDAO.getCategory(5);
	    assertTrue("Could'nt delete category", categoryDAO.deleteCategory(category));
		
	}
	
	@Test
	@Ignore
	public void listCategoryTest()
	{
		List<Category> listCategories = categoryDAO.listCategories();
		assertTrue("Could'nt list categories", listCategories.size()>0);
		for(Category cat :listCategories){
			System.out.println(cat.getCategoryName()+" ");
			System.out.print(cat.getCategoryDesc());
		}
	}
	
	@Test
	@Ignore
	public void getCategoryTest()
	{
		Category category = categoryDAO.getCategory(5);
		assertTrue("No category",category!=null);
		System.out.println(category.getCategoryName());
	}
	
	
}
