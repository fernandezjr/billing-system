package com.luminaamericas.billingsystem.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.luminaamericas.billingsystem.io.report.ReportGenerationException;
import com.luminaamericas.billingsystem.io.report.ReportGenerator;
import com.luminaamericas.billingsystem.model.entity.InvoicedOrder;
import com.luminaamericas.billingsystem.model.entity.Order;
import com.luminaamericas.billingsystem.model.entity.PendingOrder;
import com.luminaamericas.billingsystem.model.invoice.AbstractInvoice;
import com.luminaamericas.billingsystem.model.invoice.Invoice;
import com.luminaamericas.billingsystem.model.invoice.NullInvoice;

public class Biller implements IBiller 
{
	private Map<Order, AbstractInvoice> transactions;
	
	private double takings;
	
	public Biller()
	{
		transactions = new HashMap<Order, AbstractInvoice>();
		takings = 0;
	}

	@Override
	public double getTakings() 
	{
		return takings;
	}

	public void printOrders() 
	{
		Iterator<Map.Entry<Order, AbstractInvoice>> iterator = transactions.entrySet().iterator();
		
		while(iterator.hasNext())
		{
			Map.Entry<Order, AbstractInvoice> pair = (Map.Entry<Order, AbstractInvoice>) 
					iterator.next();
			
			System.out.println(pair.getKey());
		}
	}

	@Override
	public void bill() throws NoTransactionsException
	{
		checkEmptyTransactions();
		
		Iterator<Map.Entry<Order, AbstractInvoice>> iterator = transactions.entrySet().iterator();
		
		while(iterator.hasNext())
		{
			Map.Entry<Order, AbstractInvoice> pair = (Map.Entry<Order, AbstractInvoice>) 
					iterator.next();
			
			if(pair.getKey().getState() instanceof PendingOrder)
			{
				takings += pair.getValue().bill();
				pair.getKey().setState(new InvoicedOrder());
			}
		}
		
		removeNullInvoices();
	}
	
	private void checkEmptyTransactions() throws NoTransactionsException
	{
		if(transactions.isEmpty())
		{
			throw new NoTransactionsException("No se registran transacciones");
		}
	}
	
	@Override
	public void loadTransactions(Collection<Order> orders)
	{
		if(transactions.isEmpty())
		{
			for (Order order : orders) 
			{
				transactions.put(order, new Invoice(order));
			}
		}
	}

	@Override
	public void cancelOrder(Order orderToCancel) throws OrderNotFoundException 
	{
		if(transactions.containsKey(orderToCancel))
		{
			AbstractInvoice invoice = orderToCancel.getState().cancel(orderToCancel);
			orderToCancel.setState(new PendingOrder());
			transactions.replace(orderToCancel, invoice);
			
		}
		else 
		{
			throw new OrderNotFoundException("No se encontró la orden especificada");
		}
	}
	
	private void removeNullInvoices()
	{
		Iterator<Map.Entry<Order, AbstractInvoice>> iterator = transactions.entrySet().iterator();
		
		while(iterator.hasNext())
		{
			Map.Entry<Order, AbstractInvoice> pair = (Map.Entry<Order, AbstractInvoice>) 
					iterator.next();
			
			if(pair.getValue() instanceof NullInvoice)
			{
				iterator.remove();
				transactions.remove(pair.getKey());
			}
		}
	}

	@Override
	public void printInvoices() throws NoTransactionsException
	{
		checkEmptyTransactions();
		
		Iterator<Map.Entry<Order, AbstractInvoice>> iterator = transactions.entrySet().iterator();
		
		while(iterator.hasNext())
		{
			Map.Entry<Order, AbstractInvoice> pair = (Map.Entry<Order, AbstractInvoice>) 
					iterator.next();
			
			System.out.println(pair.getValue() + "\n");
		}
	}

	@Override
	public void generateDailyReport() 
	{
		try 
		{
			ReportGenerator.getGenerator().generate(transactions.values());
		} 
		catch (ReportGenerationException e) 
		{
			e.printStackTrace();
		}
	}
}