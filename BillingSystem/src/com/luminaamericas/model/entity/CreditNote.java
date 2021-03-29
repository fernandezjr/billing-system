package com.luminaamericas.model.entity;

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