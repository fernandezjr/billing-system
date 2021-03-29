package com.luminaamericas.model.entity;

public interface OrderState 
{
	AbstractInvoice cancel(Order order);
}