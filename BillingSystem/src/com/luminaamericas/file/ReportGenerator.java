package com.luminaamericas.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.luminaamericas.model.entity.Invoice;

public class ReportGenerator 
{
	public static void generate(List<Invoice> invoices)
	{
		FileWriter writer;
		try 
		{
			writer = new FileWriter("Reporte.txt", false);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			
			for (Invoice invoice : invoices) 
			{
				String register = invoice.getHeader().getCustomer().getFullName() + "-"
						+ invoice.getHeader().getCustomer().getIdType().name() + "-"
						+ invoice.getHeader().getLetter() + "-" 
						+ invoice.getHeader().getCustomer().getId() + "-" 
						+ invoice.getHeader().getDateOfIssue() + "-" 
						+ invoice.getFooter().getTotal();
				
				bufferedWriter.write(register);
				bufferedWriter.newLine();
			}
			
			 bufferedWriter.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}