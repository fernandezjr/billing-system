package com.luminaamericas.billingsystem.model.invoice;

public class Detail 
{
	private double porcentageCustomerCategory;
	private int quantity;
	private double sellingPrice;
	private double netPrice;
	private double ivaAmount;
	private double unitPrice;
	
	public Detail(double porcentageCustomerCategory, int quantity, double sellingPrice, double netPrice,
			double ivaAmount, double unitPrice) 
	{
		this.porcentageCustomerCategory = porcentageCustomerCategory;
		this.quantity = quantity;
		this.sellingPrice = sellingPrice;
		this.netPrice = netPrice; 
		this.ivaAmount = ivaAmount;
		this.unitPrice = unitPrice;
	}

	public double getPorcentageCustomerCategory() 
	{
		return porcentageCustomerCategory;
	}

	public int getQuantity() 
	{
		return quantity;
	}

	public double getSellingPrice() 
	{
		return sellingPrice;
	}

	public double getNetPrice() 
	{
		return netPrice;
	}

	public double getIvaAmount() 
	{
		return ivaAmount;
	}
	
	public double getUnitPrice()
	{
		return unitPrice;
	}

	@Override
	public String toString() 
	{
		return "Precio Unitario: $" + unitPrice + "\nCantidad: " + quantity 
				+ "\tPrecio Neto: $" + netPrice + "\nIVA: " + porcentageCustomerCategory 
				+ "%\tPrecio de Venta: $" + sellingPrice + "\nMonto de IVA: $" + ivaAmount;
	}
}