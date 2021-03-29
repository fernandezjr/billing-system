package com.luminaamericas.billingsystem.model.entity;

import com.luminaamericas.billingsystem.model.invoice.AbstractInvoice;
import com.luminaamericas.billingsystem.model.invoice.CreditNote;

public class InvoicedOrder implements OrderState 
{
	@Override
	public AbstractInvoice cancel(Order order) 
	{
		return new CreditNote(order);
	}
}