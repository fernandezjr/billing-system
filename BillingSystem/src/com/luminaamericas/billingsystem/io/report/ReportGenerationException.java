package com.luminaamericas.billingsystem.io.report;

public class ReportGenerationException extends Exception 
{
	private static final long serialVersionUID = 1L;
	
	public ReportGenerationException() 
	{
		super();
	}
	
	public ReportGenerationException(String message, Throwable cause) 
	{
	    super(message, cause);
	}
}