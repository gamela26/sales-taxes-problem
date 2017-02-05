package me.daniel.sales_taxes_problem;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		String path;
		
		if(args.length > 0){
			path = args[0];
		}else{
			System.out.println("Error: Bad filename.\nSyntax: program <filename>.txt");
			return;
		}
		
		Cart cart = new Cart();
		
		try {
			cart.importFromFile(path);
		} catch (IOException e) {
			System.out.println("Error: file: " + path + " dosen't exists");
			return;
		}
		
		System.out.println(cart);
		

	}

}
