package com.luminaamericas.billingsystem.model.entity;

import com.luminaamericas.billingsystem.model.invoice.AbstractInvoice;

public interface OrderState 
{
	AbstractInvoice cancel(Order order);
}