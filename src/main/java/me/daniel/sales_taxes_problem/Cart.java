package me.daniel.sales_taxes_problem;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Cart {
	
	private SalesTaxStrategy salesTax;
	private CartImportStrategy importer;
	private Map<OrderItem, BigDecimal> items;
	
	public Cart(){
		this.salesTax = new BaseSalesTax();
		this.importer = new CartFileImporter();
		this.items = new HashMap<OrderItem, BigDecimal>();
	}
	
	public void importFromFile(String path) throws IOException{
		this.importer.importCart(path).forEach((x)->{
			items.put(x, this.salesTax.calculate(x.getProduct()));
		});
	}
	
	public BigDecimal getTotalTax(){		
		return items.entrySet().stream()
				.map((x)->{
					BigDecimal qty = new BigDecimal(x.getKey().getQuantity());
					BigDecimal tax = x.getValue();
					return qty.multiply(tax);
				})
				.reduce(BigDecimal.ZERO, (sum, x) -> sum.add(x))
				.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
	
	public BigDecimal getTotal(){
		return items.entrySet().stream()
				.map((x)->{
					BigDecimal qty = new BigDecimal(x.getKey().getQuantity());
					BigDecimal price = x.getKey().getProduct().getPrice();
					BigDecimal tax = x.getValue();
					return qty.multiply(price.add(tax));
				}) 
				.reduce(BigDecimal.ZERO, (sum, x) -> sum.add(x))
				.setScale(2, BigDecimal.ROUND_HALF_UP);
	}
}
