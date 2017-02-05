package me.daniel.sales_taxes_problem;

import java.io.IOException;

public class Cart {
	
	private SalesTaxStrategy salesTax;
	private CartImportStrategy importer;
	
	public Cart(){
		this.salesTax = new BaseSalesTax();
		this.importer = new CartFileImporter();
	}
	
	public void importFromFile(String path) throws IOException{
		this.importer.importCart(path);
	}
}
