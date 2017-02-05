package me.daniel.sales_taxes_problem;

import java.math.BigDecimal;

public class OrderItem {

	private final Integer quantity;
	private final Product product;
	
	public OrderItem(Integer quantity, Product product){
		this.quantity = quantity;
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Product getProduct() {
		return product;
	}
	
	public BigDecimal getTotalTax(SalesTaxStrategy taxStrategy){
		BigDecimal qty = new BigDecimal(this.quantity);
		BigDecimal tax = taxStrategy.calculate(this.product);
		return qty.multiply(tax).setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	public BigDecimal getTotalNetPrice(){
		BigDecimal qty = new BigDecimal(this.quantity);
		return qty.multiply(this.product.getPrice()).setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	public BigDecimal getTotalPrice(SalesTaxStrategy taxStrategy){
		BigDecimal totalNetPrice = this.getTotalNetPrice(); 
		BigDecimal totalTax = this.getTotalTax(taxStrategy);
		return totalNetPrice.add(totalTax).setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	@Override
	public String toString(){
		StringBuilder str = new StringBuilder("");
		str.append(this.quantity);
		str.append(" " + this.product.getName() +" at ");
		str.append(this.product.getPrice());
		
		return str.toString();
	}
	
	@Override
	public boolean equals(Object o) {
	
		if (o == this){
			return true;
		}
	
		if (!(o instanceof OrderItem)) {
		    return false;
		}
	
		OrderItem orderItem = (OrderItem) o;
		
		return this.quantity.equals(orderItem.quantity) &&
			   this.product.equals(orderItem.product);
	}	
}