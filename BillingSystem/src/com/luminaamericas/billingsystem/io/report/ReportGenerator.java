package com.luminaamericas.billingsystem.io.report;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import com.luminaamericas.billingsystem.model.invoice.AbstractInvoice;

public class ReportGenerator 
{
	private static ReportGenerator generator;
	
	private ReportGenerator() {}
	
	public static ReportGenerator getGenerator()
	{
		if(generator == null)
		{
			return new ReportGenerator();
		}
		
		return generator;
	}
	
	public void generate(Collection<AbstractInvoice> invoices) throws ReportGenerationException
	{
		FileWriter writer;
		try 
		{
			writer = new FileWriter(createFile().getAbsoluteFile(), false);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			
			for (AbstractInvoice invoice : invoices) 
			{
				String date = new SimpleDateFormat("dd/MM/yyyy")
						.format(invoice.getHeader().getDateOfIssue());
				
				String register = invoice.getHeader().getCustomer().getFullName() + "-"
						+ invoice.getHeader().getCustomer().getIdType().name() + "-"
						+ invoice.getHeader().getLetter() + "-" 
						+ invoice.getHeader().getCustomer().getId() + "-" 
						+ date + "-" + invoice.getFooter().getTotal();
				
				bufferedWriter.write(register);
				bufferedWriter.newLine();
			}
			
			 bufferedWriter.close();
		} 
		catch (IOException e) 
		{
			throw new ReportGenerationException("El reporte no se ha podido generar", e);
		}
	}
	
	private File createFile()
	{
		File directory = new File("reports");
		File fileName = new File(new SimpleDateFormat("dd-MM-yyyy").format(new Date()) 
				+ ".txt");
		directory.mkdir();
		return new File(directory + "/" + fileName);
	}
}