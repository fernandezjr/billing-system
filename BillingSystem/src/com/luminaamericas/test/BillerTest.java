package com.luminaamericas.test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.luminaamericas.model.Biller;
import com.luminaamericas.model.entity.Address;
import com.luminaamericas.model.entity.Customer;
import com.luminaamericas.model.entity.IdType;
import com.luminaamericas.model.entity.Order;
import com.luminaamericas.model.entity.Product;

public class BillerTest 
{
	/*public static void main(String[] args) 
	{
		Product rice = new Product(1, "Arroz Arcor 500 grs", 55);
		Product water = new Product(2, "Agua Villavicencio 2L", 90.50);
		
		Date date = new GregorianCalendar(2021, Calendar.MARCH, 17).getTime();
		Date date2 = new GregorianCalendar(2021, Calendar.MARCH, 18).getTime();
		
		Address house = new Address("Lavallol", 3045, "Tortuguitas");
		Customer rodrigo = new Customer(1, 36824421, IdType.DNI, "Rodrigo Fernández", 
				house);
		
		Order marketOrder = new Order(1, date, rodrigo);
		
		marketOrder.addProduct(rice, 10);
		marketOrder.addProduct(water, 3);
		
		Order otherOrder = new Order(2, date2, rodrigo);
		
		otherOrder.addProduct(water, 21);
		
		Biller biller = new Biller();
		biller.addOrder(marketOrder);
		biller.addOrder(otherOrder);
		
		biller.printOrders();
	}*/
}