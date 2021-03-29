package com.luminaamericas.model.entity;

public class InvoicedOrder implements OrderState 
{
	@Override
	public AbstractInvoice cancel(Order order) 
	{
		return new CreditNote(order);
	}
}