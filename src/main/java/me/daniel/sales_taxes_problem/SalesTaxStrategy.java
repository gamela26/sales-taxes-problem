package me.daniel.sales_taxes_problem;

import java.math.BigDecimal;

public interface SalesTaxStrategy {
	public BigDecimal calculate(Product product);
}