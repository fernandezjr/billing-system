package com.luminaamericas.model.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Header 
{
	private int number;
	private Date dateOfIssue;
	private String emissionCode;
	private String letter;
	private Customer customer;
	
	public Header(int number, String emissionCode, String letter, Customer customer) 
	{
		this.number = number;
		this.dateOfIssue = new Date();
		this.emissionCode = emissionCode;
		this.letter = letter;
		this.customer = customer;
	}

	public int getNumber() 
	{
		return number;
	}

	public Date getDateOfIssue() 
	{
		return dateOfIssue;
	}

	public String getEmissionCode() 
	{
		return emissionCode;
	}

	public String getLetter() 
	{
		return letter;
	}

	public Customer getCustomer() 
	{
		return customer;
	}

	@Override
	public String toString() 
	{
		return "Factura #" + number + "\tFecha: " 
				+ new SimpleDateFormat("dd/MM/yyyy").format(dateOfIssue) 
				+ "\nCódigo de Emisión: " + emissionCode + "\tTipo: " + letter + "\n";
	}
}