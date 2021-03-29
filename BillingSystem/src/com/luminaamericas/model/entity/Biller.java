package com.luminaamericas.model.entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.luminaamericas.io.report.ReportGenerator;
import com.luminaamericas.model.IBiller;
import com.luminaamericas.model.OrderNotFoundException;

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

	@Override
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
	public void bill() 
	{
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
			throw new OrderNotFoundException();
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
	public void printInvoices() 
	{
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
		ReportGenerator.generate(transactions.values());
	}
}