package me.daniel.sales_taxes_problem;

import static org.junit.Assert.*;

import java.io.IOException;
import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class CartTest {

	private Cart cart;
	
	@Before
	public void setUp(){
		cart = new Cart();
	}
	
	@Test
	public void testCart1() throws IOException {
		cart.importFromFile("files/cart1.txt");
		BigDecimal expectedTax = new BigDecimal(1.50).setScale(2, BigDecimal.ROUND_HALF_UP);
		BigDecimal expectedTotal = new BigDecimal(29.83).setScale(2, BigDecimal.ROUND_HALF_UP);
		
		assertEquals(expectedTax, cart.getTotalTax());
		assertEquals(expectedTotal, cart.getTotal());
	}
	
	@Test
	public void testCart2() throws IOException {
		cart.importFromFile("files/cart2.txt");
		BigDecimal expectedTax = new BigDecimal(7.65).setScale(2, BigDecimal.ROUND_HALF_UP);
		BigDecimal expectedTotal = new BigDecimal(65.15).setScale(2, BigDecimal.ROUND_HALF_UP);
		
		assertEquals(expectedTax, cart.getTotalTax());
		assertEquals(expectedTotal, cart.getTotal());
	}
	
	@Test
	public void testCart3() throws IOException {
		cart.importFromFile("files/cart3.txt");
		BigDecimal expectedTax = new BigDecimal(6.70).setScale(2, BigDecimal.ROUND_HALF_UP);
		BigDecimal expectedTotal = new BigDecimal(74.68).setScale(2, BigDecimal.ROUND_HALF_UP);
		
		assertEquals(expectedTax, cart.getTotalTax());
		assertEquals(expectedTotal, cart.getTotal());
	}

}
