package me.daniel.sales_taxes_problem;

import java.math.BigDecimal;

public class Product {
	
	private String name;
	private Integer quantity;
	private ProductType type;
	private Boolean imported;
	private BigDecimal price;
	
	public Product(String name, Integer quantity, ProductType type, Boolean imported, BigDecimal price){
		this.name = name;
		this.quantity = quantity;
		this.type = type;
		this.imported = imported;
		this.price = price;
	}
		
	public ProductType getProductType(){
		return type;
	}

	public Boolean isImported() {
		return imported;
	}

	public BigDecimal getPrice(){
		return price;
	}

}
