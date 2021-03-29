package com.luminaamericas.model.entity;

public class PendingOrder implements OrderState 
{
	@Override
	public AbstractInvoice cancel(Order order) 
	{
		return new NullInvoice(order);
	}
}