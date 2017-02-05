package me.daniel.sales_taxes_problem;

import java.math.BigDecimal;

public class Product {
	
	private final String name;
	private final ProductType type;
	private final Boolean imported;
	private final BigDecimal price;
	
	public Product(String name, ProductType type, Boolean imported, BigDecimal price){
		this.name = name;
		this.type = type;
		this.imported = imported;
		this.price = price.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	public String getName(){
		return name;
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
	
	@Override
	public String toString(){
		StringBuilder str = new StringBuilder("");
		str.append("name: " + this.name);
		str.append(", type: " + this.type);
		str.append(", imported: " + this.imported);
		str.append(", price: " + this.price);
		
		return str.toString();
	}
	
	@Override
	public boolean equals(Object o) {
	
		if (o == this){
			return true;
		}
		
		if (!(o instanceof Product)) {
		    return false;
		}
		
		Product product = (Product) o;
		
		return this.name.equals(product.name) &&
			   this.type == product.type &&
			   this.imported.equals(product.imported) &&
			   this.price.equals(product.price);
	}
}
