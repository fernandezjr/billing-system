package com.luminaamericas.file;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileGenerator 
{
	public void generate()
	{
		FileWriter writer;
		try 
		{
			writer = new FileWriter("Reporte.txt", true);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			bufferedWriter.write("Reporte");
			bufferedWriter.newLine();
			bufferedWriter.write("Prueba");
			bufferedWriter.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}        
	}
}