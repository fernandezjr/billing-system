package com.luminaamericas.model.entity;

public class Customer 
{
	private int number;
	private long id;
	private IdType idType;
	private String fullName;
	private Address address;
	private IvaCategory ivaCategory;
	
	public Customer(int number, long id, IdType idType, String fullName, Address address, 
			IvaCategory ivaCategory) 
	{
		this.number = number;
		this.id = id;
		this.idType = idType;
		this.fullName = fullName;
		this.address = address;
		this.ivaCategory = ivaCategory;
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
	
	public IvaCategory getIvaCategory() 
	{
		return ivaCategory;
	}

	@Override
	public String toString() 
	{
		return "Cliente #" + number + "\tNombre: " + fullName + "\t" 
				+ idType.name() + ": " + id +  "\tDirección: " + address + "\t" + ivaCategory;
	}
}