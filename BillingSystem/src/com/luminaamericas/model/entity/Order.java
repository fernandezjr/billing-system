package com.luminaamericas.model.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
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

	@Override
	public String toString() 
	{
		return "Pedido: " + number + "\nFecha: " + date + "\n" + 
				customer + "\nProductos:\n" + productsToString() + "Total: " + 
				getTotal() + "\n";
	}
	
	private String productsToString()
	{
		String productsList = "";
		Iterator<Map.Entry<Product, Integer>> iterator = products.entrySet().iterator();
		
		while (iterator.hasNext()) 
		{
			Map.Entry<Product, Integer> pair = (Map.Entry<Product, Integer>) iterator.next();
			productsList += pair.getKey() + " Cantidad: " + pair.getValue() + "\n";
		}
		
		return productsList;
	}
	
	public double getTotal()
	{
		double total = 0;
		Iterator<Map.Entry<Product, Integer>> iterator = products.entrySet().iterator();
		
		while (iterator.hasNext()) 
		{
			Map.Entry<Product, Integer> pair = (Map.Entry<Product, Integer>) iterator.next();
			total += pair.getKey().getPrice() * pair.getValue();
		}
		
		return total;
	}
	
	public Map<Product, Detail> getProductsDetail()
	{
		Map<Product, Detail> productsDetails = new HashMap<Product, Detail>();
		Iterator<Map.Entry<Product, Integer>> iterator = products.entrySet().iterator();
		
		while (iterator.hasNext()) 
		{
			Map.Entry<Product, Integer> pair = (Map.Entry<Product, Integer>) iterator.next();
			
			Product product = pair.getKey();
			double unitPrice = product.getPrice();
			double ivaPercentage = customer.getIvaCategory().getPercentage();
			int quantity = pair.getValue();
			double netPrice = unitPrice * quantity;
			double sellingPrice = netPrice + ivaPercentage;
			
			Detail detail = new Detail(ivaPercentage, pair.getValue(), sellingPrice, netPrice, 
					ivaPercentage, unitPrice);
			
			productsDetails.put(product, detail);
		}
		
		return productsDetails;
	}
}