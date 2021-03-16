package com.luminaamericas.entity;

public class Address 
{
	private String street;
	private int number;
	private String floor;
	private String apartment;
	private String city;
	
	public Address(String street, int number, String floor, String apartment, String city) 
	{
		this.street = street;
		this.number = number;
		this.floor = floor;
		this.apartment = apartment;
		this.city = city;
	}

	public String getStreet() 
	{
		return street;
	}

	public int getNumber() 
	{
		return number;
	}

	public String getFloor() 
	{
		return floor;
	}

	public String getApartment() 
	{
		return apartment;
	}

	public String getCity() 
	{
		return city;
	}
}