package com.luminaamericas.billingsystem.test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;

import com.luminaamericas.billingsystem.model.Biller;
import com.luminaamericas.billingsystem.model.IBiller;
import com.luminaamericas.billingsystem.model.NoTransactionsException;
import com.luminaamericas.billingsystem.model.OrderNotFoundException;
import com.luminaamericas.billingsystem.model.entity.Address;
import com.luminaamericas.billingsystem.model.entity.Customer;
import com.luminaamericas.billingsystem.model.entity.IdType;
import com.luminaamericas.billingsystem.model.entity.IvaCategory;
import com.luminaamericas.billingsystem.model.entity.Order;
import com.luminaamericas.billingsystem.model.entity.Product;

public class BillerTest 
{
	public static void main(String[] args) throws OrderNotFoundException, NoTransactionsException 
	{
		Product rice = new Product(1, "Arroz Arcor 500 grs", 55);
		Product water = new Product(2, "Agua Villavicencio 2L", 90.50);
		
		Date date = new GregorianCalendar(2021, Calendar.MARCH, 17).getTime();
		Date date2 = new GregorianCalendar(2021, Calendar.MARCH, 18).getTime();
		
		Address house = new Address("Lavallol", 3045, "Tortuguitas");
		Customer rodrigo = new Customer(1, 36824421, IdType.DNI, "Rodrigo Fernández", 
				house, IvaCategory.B);
		
		Order marketOrder = new Order(1, date, rodrigo);
		
		marketOrder.addProduct(rice, 10);
		marketOrder.addProduct(water, 3);
		
		Order otherOrder = new Order(2, date2, rodrigo);
		
		otherOrder.addProduct(water, 21);
		
		IBiller biller = new Biller();
		
		Collection<Order> orders = new ArrayList<Order>();
		
		orders.add(marketOrder);
		orders.add(otherOrder);
		
		biller.loadTransactions(orders);
		
//		Genera Nota de Credito
		biller.bill();
		biller.cancelOrder(otherOrder);
		biller.bill();
		
//		Elimina la orden
//		biller.cancelOrder(otherOrder);
//		biller.bill(orders);
//		
		biller.printInvoices();
		System.out.println("Ingresos: $" + biller.getTakings());
		biller.generateDailyReport();
	}
}