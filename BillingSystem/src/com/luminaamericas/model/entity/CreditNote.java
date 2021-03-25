package com.luminaamericas.model.entity;

public class CreditNote 
{
	private Header header;
	private Footer footer;
	
	public CreditNote(Header header, Footer footer) 
	{
		this.header = header;
		this.footer = footer;
	}

	public Header getHeader() 
	{
		return header;
	}

	public Footer getFooter() 
	{
		return footer;
	}	
}