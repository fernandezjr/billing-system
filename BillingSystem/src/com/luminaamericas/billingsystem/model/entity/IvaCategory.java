package com.luminaamericas.billingsystem.model.entity;

public enum IvaCategory 
{
	A("Iva Responsable Inscripto", 10.05), B("Monotributo", 21), X("IVA no Responsable", 70);
	
	private String description;
	private double percentage;
	
	private IvaCategory(String description, double percentage)
	{
		this.description = description;
		this.percentage = percentage;
	}

	public String getDescription() 
	{
		return description;
	}

	public double getPercentage() 
	{
		return percentage;
	}

	@Override
	public String toString() 
	{
		return this.name() + ": " + description + " - " + percentage + "%";
	}
}