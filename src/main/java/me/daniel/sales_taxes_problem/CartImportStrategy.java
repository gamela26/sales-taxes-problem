package me.daniel.sales_taxes_problem;

import java.io.IOException;
import java.util.List;

public interface CartImportStrategy {
	public List<OrderItem> importCart(String path)throws IOException;	
}
