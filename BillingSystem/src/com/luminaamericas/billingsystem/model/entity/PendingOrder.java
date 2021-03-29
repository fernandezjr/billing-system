package com.luminaamericas.billingsystem.model.entity;

import com.luminaamericas.billingsystem.model.invoice.AbstractInvoice;
import com.luminaamericas.billingsystem.model.invoice.NullInvoice;

public class PendingOrder implements OrderState 
{
	@Override
	public AbstractInvoice cancel(Order order) 
	{
		return new NullInvoice(order);
	}
}