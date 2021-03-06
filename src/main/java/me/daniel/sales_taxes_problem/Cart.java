package me.daniel.sales_taxes_problem;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class Cart {
	
	private SalesTaxStrategy taxStrategy;
	private CartImportStrategy importStrategy;
	private List<OrderItem> orderItems;
	
	public Cart(){
		this.taxStrategy = new BaseSalesTax();
		this.importStrategy = new CartFileImporter();
	}
	
	public void importFromFile(String path) throws IOException{
		this.orderItems = this.importStrategy.importCart(path);
	}
	
	public BigDecimal getTotalTax(){		
		return orderItems.stream()
				.map((x)-> x.getTotalTax(taxStrategy))
				.reduce(BigDecimal.ZERO, (sum, x) -> sum.add(x))
				.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	public BigDecimal getTotal(){
		return orderItems.stream()
				.map((x)-> x.getTotalPrice(taxStrategy)) 
				.reduce(BigDecimal.ZERO, (sum, x) -> sum.add(x))
				.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	@Override
	public String toString(){
		
		StringBuilder str = new StringBuilder();
		
		orderItems.forEach((x)->{
			str.append(x.getQuantity());
			str.append(" " + x.getProduct().getName() + " at ");
			str.append(x.getTotalPrice(taxStrategy));
			str.append("\n");
		});
		str.append("Sales Taxes: ");
		str.append(this.getTotalTax());
		str.append("\nTotal: ");
		str.append(this.getTotal());
		
		return str.toString();
	}
}
