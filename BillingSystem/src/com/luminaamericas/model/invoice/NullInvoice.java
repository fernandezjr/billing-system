package com.luminaamericas.model.invoice;

import com.luminaamericas.model.entity.Order;

public class NullInvoice extends AbstractInvoice 
{
	public NullInvoice(Order order) 
	{
		super(order);
		header = null;
	}

	@Override
	public String toString() 
	{
		return "";
	}

	@Override
	public double bill() 
	{
		return 0;
	}
}