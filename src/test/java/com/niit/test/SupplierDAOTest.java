package com.niit.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.SystemPropertyUtils;

import com.niit.dao.SupplierDAO;
import com.niit.model.Category;
import com.niit.model.Supplier;

public class SupplierDAOTest {
static SupplierDAO supplierDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
	}
	
	@Test
	@Ignore
	public void addSupplierTest()
	{
		Supplier supplier = new Supplier();
		supplier.setSupplierName("Mukesh");
		assertTrue("no supplier added",supplierDAO.addSupplier(supplier));
	}
	
	@Test
	@Ignore
	public void updateSupplierTest()
	{
		Supplier supplier = supplierDAO.getSupplier(6);
		supplier.setSupplierAddress(234);
		assertTrue("no supplier updated",supplierDAO.updateSupplier(supplier));
	}
	
	@Test
	@Ignore
	public void deleteCatergoryTest()
	{
		Supplier supplier  = supplierDAO.getSupplier(6);
	    assertTrue("Could'nt delete supplier", supplierDAO.deleteSupplier(supplier));
		
	}
	
	@Test
	@Ignore
	public void listSupplierTest()
	{
		List<Supplier> listSuppliers = supplierDAO.listSupplier();
		assertTrue("Could'nt list categories", listSuppliers.size()>0);
		for(Supplier sup :listSuppliers){
			System.out.println(sup.getSupplierName()+" ");
			System.out.print(sup.getSupplierAddress());
		}
	}
	
	@Test
	@Ignore
	public void getSupplierTest()
	{
		Supplier supplier  = supplierDAO.getSupplier(6);
		assertTrue("No supplier",supplier!=null);
		System.out.println(supplier.getSupplierName());
	}
	
	
}
