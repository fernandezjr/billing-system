package com.luminaamericas.entity;

public class Customer 
{
	private int number;
	private long id;
	private IdType idType;
	private String fullName;
	private Address address;
	
	public Customer(int number, long id, IdType idType, String fullName, Address address) 
	{
		this.number = number;
		this.id = id;
		this.idType = idType;
		this.fullName = fullName;
		this.address = address;
	}

	public int getNumber() 
	{
		return number;
	}

	public long getId() 
	{
		return id;
	}

	public IdType getIdType() 
	{
		return idType;
	}

	public String getFullName() 
	{
		return fullName;
	}

	public Address getAddress() 
	{
		return address;
	}

	@Override
	public String toString() 
	{
		return "Número: " + number + "\n" + idType.name() + ": " + id + 
				"\n" + "Nombre: " + fullName + "\n" + "Dirección: " + address;
	}
}