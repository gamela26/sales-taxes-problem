package me.daniel.sales_taxes_problem;

import java.util.Arrays;
import java.util.List;

public enum ProductType {
	BOOKS, FOOD, MEDICAL, OTHER;
	
	private static final List<String> BOOK_LIST = (List<String>) Arrays.asList("book");
	private static final List<String> FOOD_LIST= (List<String>) Arrays.asList("chocolate");
	private static final List<String> MEDICAL_LIST = (List<String>) Arrays.asList("pills");
	
	public static ProductType getProductType(String str){
		
		if(BOOK_LIST.stream().anyMatch((s)->str.contains(s))){
			return ProductType.BOOKS;
		}
		
		if(FOOD_LIST.stream().anyMatch((s)->str.contains(s))){
			return ProductType.FOOD;
		}
		
		if(MEDICAL_LIST.stream().anyMatch((s)->str.contains(s))){
			return ProductType.MEDICAL;
		}
		return OTHER;
	}
	
}
