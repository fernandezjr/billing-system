package com.luminaamericas.billingsystem.model;

import java.util.Collection;

import com.luminaamericas.billingsystem.model.entity.Order;

public interface IBiller 
{
	double getTakings();
	
	void bill() throws NoTransactionsException;
	
	void cancelOrder(Order orderToCancel) throws OrderNotFoundException;
	
	void printInvoices() throws NoTransactionsException;
	
	void generateDailyReport();
	
	void loadTransactions(Collection<Order> orders);
}