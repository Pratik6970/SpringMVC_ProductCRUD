package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ProductDao {
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	//create
	@Transactional
	public void createProduct(Product product)
	{
		System.out.println("createProduct here");
		
		hibernateTemplate.saveOrUpdate(product);
	}
	
	//get all product
	@Transactional
	public List<Product>getAllProduct()
	{
		System.out.println("List of Product here");
		List<Product>products=hibernateTemplate.loadAll(Product.class);
		return products;
	}
	
	//delete product
	@Transactional
	public void delete_Product(int pid)
	{
		
		System.out.println("delete call here");
		
		Product p = hibernateTemplate.load(Product.class, pid);
		hibernateTemplate.delete(p);
		
	}
	
	//single product get
	@Transactional
	public Product singleproduct(int pid)
	{
		return hibernateTemplate.get(Product.class, pid);
		
	}
	
	

   
}
