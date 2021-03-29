package com.luminaamericas.model.invoice;

import com.luminaamericas.model.entity.Customer;
import com.luminaamericas.model.entity.Order;

public abstract class AbstractInvoice 
{
	protected Header header;
	protected Footer footer;
	
	public AbstractInvoice(Order order)
	{
		Customer customer = order.getCustomer();
		this.header = new Header(1, "ABC123", customer.getIvaCategory().name(), customer);
		double total = order.getTotal();
		this.footer = new Footer(total);
	}
	
	public abstract double bill();
	
	public Header getHeader() 
	{
		return header;
	}

	public Footer getFooter() 
	{
		return footer;
	}
}