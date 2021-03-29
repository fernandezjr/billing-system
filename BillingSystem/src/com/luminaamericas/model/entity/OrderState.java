package com.luminaamericas.model.entity;

import com.luminaamericas.model.invoice.AbstractInvoice;

public interface OrderState 
{
	AbstractInvoice cancel(Order order);
}