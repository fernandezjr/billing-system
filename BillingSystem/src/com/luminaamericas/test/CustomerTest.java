package com.luminaamericas.test;

import com.luminaamericas.entity.Address;
import com.luminaamericas.entity.Customer;
import com.luminaamericas.entity.IdType;

public class CustomerTest 
{
	public static void main(String[] args) 
	{
		Address apartment = new Address("Gelly y Obes", 4493, "PB", "B", "Jos� C. Paz");
		Address house = new Address("Lavallol", 3045, "Tortuguitas");
		Customer rodrigo = new Customer(1, 36824421, IdType.DNI, "Rodrigo Fern�ndez", 
				house);
		
		System.out.println(rodrigo);
	}
}