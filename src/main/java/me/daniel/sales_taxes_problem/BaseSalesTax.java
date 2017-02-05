package me.daniel.sales_taxes_problem;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

public class BaseSalesTax implements SalesTaxStrategy {

	private final List<ProductType> EXLUDED = Arrays.asList(ProductType.BOOKS, ProductType.FOOD, ProductType.MEDICAL);
	private final BigDecimal RATE = new BigDecimal(0.1);
	private final BigDecimal IMPORT_RATE = new BigDecimal(0.05);
	private final BigDecimal ROUND_TO = new BigDecimal(0.05);
	
	@Override
	public BigDecimal calculate(Product product) {
		BigDecimal tax = new BigDecimal(0);
		
		if(!EXLUDED.contains(product.getProductType())){
			tax = tax.add(product.getPrice().multiply(RATE));
		}
		
		if(product.isImported()){
			tax = tax.add(product.getPrice().multiply(IMPORT_RATE));
		}

		return rounds(tax);
	}
	
	private BigDecimal rounds(BigDecimal tax){
		BigDecimal div = tax.divide(ROUND_TO).setScale(0, RoundingMode.CEILING);		
		return div.multiply(ROUND_TO).setScale(2, BigDecimal.ROUND_HALF_UP);
	}
}