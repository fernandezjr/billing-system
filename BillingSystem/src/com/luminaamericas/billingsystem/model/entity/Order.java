package com.luminaamericas.billingsystem.model.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.luminaamericas.billingsystem.model.invoice.Detail;

public class Order 
{
	private int number;
	private Date date;
	private Customer customer;
	private Map<Product, Integer> products;
	private OrderState state;
	
	public Order(int number, Date date, Customer customer) 
	{
		this.number = number;
		this.date = date;
		this.customer = customer;
		products = new HashMap<Product, Integer>();
		state = new PendingOrder();
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
	
	public void removeProduct(Product productToRemove)
	{
		products.remove(productToRemove);
	}
	
	public void changeQuantity(Product product, int newQuantity)
	{
		products.replace(product, newQuantity);
	}
	
	public OrderState getState() 
	{
		return state;
	}

	public void setState(OrderState state) 
	{
		this.state = state;
	}

	@Override
	public String toString() 
	{
		String productsSeparator = "\n-------- Productos --------\n";
		return "Pedido #" + number + "\tFecha: " 
				+ new SimpleDateFormat("dd/MM/yyyy").format(date) + "\n" 
				+ customer +  productsSeparator + productsToString() 
				+ "Total: " + getTotal() + "\n";
	}
	
	@Override
	public boolean equals(Object other) 
	{
		if (other instanceof Order) 
		{
			Order otherOrder = (Order) other;
			return (this.number == otherOrder.number);
		}
		
		return false;
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