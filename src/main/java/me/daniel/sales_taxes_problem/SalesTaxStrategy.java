package me.daniel.sales_taxes_problem;

import java.math.BigDecimal;

public interface SalesTaxStrategy {
	BigDecimal apply(Product product);
}
