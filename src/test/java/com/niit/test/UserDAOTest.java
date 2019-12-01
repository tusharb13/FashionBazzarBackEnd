package com.niit.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.dao.UserDAO;
import com.niit.model.UserDetail;

public class UserDAOTest {
static UserDAO userDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		userDAO=(UserDAO)context.getBean("userDAO");
	}
	
	@Test
	//@Ignore
	public void registerUserTest()
	{
		UserDetail userDetail = new UserDetail();
		userDetail.setCustomerName("Tushar");
		userDetail.setAddress("A-262A");
		userDetail.setEmail("ty@gmail.com");
		userDetail.setEnabled("true");
		userDetail.setMobile("9810222");
		userDetail.setPassword("qwerty1234");
		userDetail.setRole("user");
		userDetail.setUsername("tushar13");
		assertTrue("Could'nt add user",userDAO.registerUser(userDetail));
	}
	
	@Test
	@Ignore
	public void updateUserTest()
	{
		UserDetail userDetail = userDAO.getUserDetail("tushar13");
		userDetail.setCustomerName("Tushar Bhatnagar");
		assertTrue("Could'nt update user",userDAO.updateUser(userDetail));
		
	}
	
	@Test
	@Ignore
	public void getUserDetailTest()
	{
		UserDetail userDetail = userDAO.getUserDetail("tushar13");
		assertTrue("Could'nt find user",userDetail!=null);
		System.out.println(userDetail.getCustomerName());
	}
}	
