package com.luminaamericas.model.entity;

public class Product 
{
	private int number;
	private String description;
	private double price;
	
	public Product(int number, String description, double price) 
	{
		this.number = number;
		this.description = description;
		this.price = price;
	}

	public int getNumber() 
	{
		return number;
	}

	public String getDescription() 
	{
		return description;
	}

	public double getPrice() 
	{
		return price;
	}

	@Override
	public String toString() 
	{
		return description + " Precio Unitario: " + price;
	}
}