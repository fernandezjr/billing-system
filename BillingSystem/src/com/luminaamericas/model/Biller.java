package com.luminaamericas.model;

import java.util.ArrayList;
import java.util.List;

import com.luminaamericas.file.ReportGenerator;
import com.luminaamericas.model.entity.Invoice;
import com.luminaamericas.model.entity.Order;

public class Biller 
{
	private List<Order> orders;
	private List<Invoice> invoices;
	
	public Biller()
	{
		orders = new ArrayList<Order>();
		invoices = new ArrayList<Invoice>();
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
	
	public void bill()
	{
		for (Order order : orders) 
		{
			invoices.add(new Invoice(order));
		}
	}
	
	public void printInvoices()
	{
		for (Invoice invoice : invoices) 
		 {
			System.out.println(invoice);
		}
	}
	
	public void generateDailyReport()
	{
		ReportGenerator.generate(invoices);
	}
}