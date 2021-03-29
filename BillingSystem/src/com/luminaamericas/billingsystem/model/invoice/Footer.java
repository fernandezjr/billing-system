package com.luminaamericas.billingsystem.model.invoice;

public class Footer 
{
	private double total;
	
	public Footer(double total) 
	{
		this.total = total;
	}

	public double getTotal() 
	{
		return total;
	}

	@Override
	public String toString() 
	{
		String footerSeparator = "---------- Pie ----------\n";
		return footerSeparator + "Total: $" + total;
	}
}