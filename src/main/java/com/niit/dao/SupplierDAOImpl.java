package com.niit.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Category;
import com.niit.model.Supplier;

@Repository("supplierDAO") //used to create bean 
@Transactional
public class SupplierDAOImpl implements SupplierDAO {
	@Autowired
	SessionFactory sessionFactory;

	public boolean addSupplier(Supplier supplier) {
		try{
			sessionFactory.getCurrentSession().save(supplier);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public boolean updateSupplier(Supplier supplier) {
		try{
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public boolean deleteSupplier(Supplier supplier) {
		try{
			sessionFactory.getCurrentSession().delete(supplier);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public Supplier getSupplier(int supplierId) {
		try{
			Session session = sessionFactory.getCurrentSession();
			Supplier supplier = (Supplier)session.get(Supplier.class,supplierId);
			
			return supplier;
		}
		catch(Exception e){
			return null;
		}
	}

	public List<Supplier> listSupplier() {
		try{
			Session session = sessionFactory.openSession();
			Query query = session.createQuery("from Supplier");
			List<Supplier> listSuppliers=query.list();
			session.close();
			return listSuppliers;
		}
		catch(Exception e){
			return null;
		}
	}
	
}
