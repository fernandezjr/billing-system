package com.luminaamericas.model.invoice;

import java.util.Iterator;
import java.util.Map;

import com.luminaamericas.model.entity.Order;
import com.luminaamericas.model.entity.Product;

public class Invoice extends AbstractInvoice
{
	private Map<Product, Detail> products;
	private double totalIVA;
	
	public Invoice(Order order)
	{
		super(order);
		products = order.getProductsDetail();
		totalIVA = footer.getTotal() * order.getCustomer().getIvaCategory().getPercentage();
	}
	
	public double getTotalIVA() 
	{
		return totalIVA;
	}

	@Override
	public double bill() 
	{
		return footer.getTotal();
	}

	@Override
	public String toString() 
	{
		return header + productsDetailsToString() + footer + "\tTotal IVA: $" + totalIVA;
	}
	
	private String productsDetailsToString()
	{
		String productsDetails = "------------ Detalle ------------\n";
		Iterator<Map.Entry<Product, Detail>> iterator = products.entrySet().iterator();
		
		while (iterator.hasNext()) 
		{
			Map.Entry<Product, Detail> pair = (Map.Entry<Product, Detail>) iterator.next();
			productsDetails += pair.getKey() + "\t" + pair.getValue() + "\n";
		}
		
		return productsDetails;
	}
}