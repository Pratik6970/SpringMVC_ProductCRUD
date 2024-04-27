package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.app.dao.Product;
import com.app.dao.ProductDao;

@Controller
public class MainController {
	
	@Autowired
	private ProductDao productdao;
	
	public MainController() {
		System.out.println("MainController() ctor called"+getClass().getName());
	}
	
	@RequestMapping("/")
	public String home(Model map)
	{
		
		System.out.println("home called here");
		
		List<Product>products=productdao.getAllProduct();
	   map.addAttribute("products", products);
		
		return "index";
		
	}
	
	
	
	
	@RequestMapping("/add")
	public String addProduct(Model map)
	{
		
		System.out.println("Add product is called here"+getClass().getName());
		map.addAttribute("title", "Add product");
		return "add_form";
		
	}
	
	@RequestMapping(value = "/handle-product",method = RequestMethod.POST)
	public RedirectView getHandler(@ModelAttribute Product product,HttpServletRequest request)
	{
		System.out.println(product);
		RedirectView redirectView= new RedirectView();
		productdao.createProduct(product);
		redirectView.setUrl(request.getContextPath() +"/");
		return redirectView;
		
	}
	
	@RequestMapping("/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable("productId")int productId,HttpServletRequest request)
	{
		this.productdao.delete_Product(productId);
		RedirectView redirectView=new RedirectView();
		redirectView.setUrl(request.getContextPath() +"/");
		return redirectView;
	}
	
	//update 
	
	@RequestMapping("/update/{productId}")
	public String updateForm(@PathVariable("productId") int productId,Model map)
	{
		
		Product product=productdao.singleproduct(productId);
		map.addAttribute("product", product);
		return "update_form";
		
	}

}
