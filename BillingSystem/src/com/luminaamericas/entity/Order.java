package com.luminaamericas.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Order 
{
	private int number;
	private Date date;
	private Customer customer;
	private Map<Product, Integer> products;
	
	public Order(int number, Date date, Customer customer) 
	{
		this.number = number;
		this.date = date;
		this.customer = customer;
		products = new HashMap<Product, Integer>();
	}

	public int getNumber() 
	{
		return number;
	}

	public Date getDate() 
	{
		return date;
	}

	public Customer getCustomer() 
	{
		return customer;
	}

	public Map<Product, Integer> getProducts() 
	{
		return products;
	}
	
	public void addProduct(Product newProduct, int quantity)
	{
		products.put(newProduct, quantity);
	}
}