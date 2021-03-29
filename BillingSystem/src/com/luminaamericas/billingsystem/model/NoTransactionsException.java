package com.luminaamericas.billingsystem.model;

public class NoTransactionsException extends Exception 
{
	private static final long serialVersionUID = 1L;

	public NoTransactionsException() 
	{
		super();
	}

	public NoTransactionsException(String message) 
	{
		super(message);
	}
}