package com.luminaamericas.model;

import java.util.ArrayList;
import java.util.List;

import com.luminaamericas.model.entity.Order;

public class Biller 
{
	private List<Order> orders;
	
	public Biller()
	{
		orders = new ArrayList<Order>();
	}
	
	public void addOrder(Order newOrder)
	{
		orders.add(newOrder);
	}
	
	public void printOrders()
	{
		for (Order order : orders) 
		{
			System.out.println(order);
		}
	}
}