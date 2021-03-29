package com.luminaamericas.model;

import java.util.Collection;

import com.luminaamericas.model.entity.Order;

public interface IBiller 
{
	double getTakings();
	
	void printOrders();
	
	void bill();
	
	void cancelOrder(Order orderToCancel) throws OrderNotFoundException;
	
	void printInvoices();
	
	void generateDailyReport();
	
	void loadTransactions(Collection<Order> orders);
}