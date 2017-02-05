package me.daniel.sales_taxes_problem;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CartFileImporter implements CartImportStrategy {

	private final String PRODUCT_REGEX = "(\\d+)\\s(.*)\\sat\\s(\\d+\\.\\d+)";
	private final String IMPORT_STR = "imported";

	private Function<String, OrderItem> createOrderItem = (str) -> {

		Pattern pattern  = Pattern.compile(PRODUCT_REGEX);
		Matcher matcher   = pattern.matcher(str);
		Product product;
		
		if (matcher.matches()) {
			Integer qty   = Integer.parseInt(matcher.group(1));
			String name = matcher.group(2);
			BigDecimal price  = new BigDecimal(matcher.group(3));
			Boolean imported = name.contains(IMPORT_STR);
			ProductType type = ProductType.getProductType(name);
			
			product = new Product(name, type, imported, price);
			return new OrderItem(qty, product);
	  
		}else{
			return null;
		}
	};
	
	
	@Override
	public List<OrderItem> importCart(String path) throws IOException{
		
		return Files.lines(Paths.get(path))
				.map(createOrderItem)
				.filter((p)-> p!=null)
				.collect(Collectors.toList());			

	}
}
