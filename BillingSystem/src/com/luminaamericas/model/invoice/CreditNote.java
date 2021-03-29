package com.luminaamericas.model.invoice;

import com.luminaamericas.model.entity.Order;

public class CreditNote extends AbstractInvoice 
{
	public CreditNote(Order order) 
	{
		super(order);
	}

	@Override
	public double bill() 
	{
		return footer.getTotal() * -1;
	}

	@Override
	public String toString() 
	{
		return header + "" +  footer;
	}
}