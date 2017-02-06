package me.daniel.sales_taxes_problem;

import java.io.IOException;

public class Main {

	public static void main(String[] args) {

		Cart cart;
		
		if(args.length == 0){
			System.out.println("Error: Bad filename.");
			System.out.println("Usage: java -jar sales-taxes-problem.jar <filename> [<filename>...]");
			return;
		}
		
		System.out.println("0UTPUT");
		
		int index = 0;
		
		for(String s: args){
			cart = new Cart();
			try {
				cart.importFromFile(s);
				index++;
				System.out.println("\n0utput " + index + ":");
				System.out.println(cart);
			} catch (IOException e) {
				System.out.println("\nError: file: " + s + " dosen't exists");
			}
		}
	}
}
