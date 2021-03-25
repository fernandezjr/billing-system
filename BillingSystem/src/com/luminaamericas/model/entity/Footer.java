package com.luminaamericas.model.entity;

public class Footer 
{
	private double total;
	private double totalIVA;
	
	public Footer(double total, double totalIVA) 
	{
		this.total = total;
		this.totalIVA = totalIVA;
	}

	public double getTotal() 
	{
		return total;
	}

	public double getTotalIVA() 
	{
		return totalIVA;
	}

	@Override
	public String toString() 
	{
		return "Total:" + total + "\nTotal IVA: " + totalIVA;
	}
}