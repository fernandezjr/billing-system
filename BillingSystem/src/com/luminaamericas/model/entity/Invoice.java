package com.luminaamericas.model.entity;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Map;

public class Invoice 
{
	private Header header;
	private Map<Product, Detail> products;
	private Footer footer;
	
	public Invoice(Order order, Header header, Footer footer)
	{
		Customer customer = order.getCustomer();
		this.header = new Header(1, new GregorianCalendar(2021, Calendar.MARCH, 25).getTime(), 
				"ABC123", customer.getIvaCategory().name(), customer);
		products = order.getProductsDetail();
		double total = order.getTotal();
		this.footer = new Footer(total, total * customer.getIvaCategory().getPercentage());
	}

	public Header getHeader() 
	{
		return header;
	}

	public Map<Product, Detail> getProducts() 
	{
		return products;
	}

	public Footer getFooter() 
	{
		return footer;
	}

	@Override
	public String toString() 
	{
		return header + "" + footer;
	}
}