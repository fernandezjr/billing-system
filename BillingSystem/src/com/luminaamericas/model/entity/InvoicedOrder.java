package com.luminaamericas.model.entity;

import com.luminaamericas.model.invoice.AbstractInvoice;
import com.luminaamericas.model.invoice.CreditNote;

public class InvoicedOrder implements OrderState 
{
	@Override
	public AbstractInvoice cancel(Order order) 
	{
		return new CreditNote(order);
	}
}