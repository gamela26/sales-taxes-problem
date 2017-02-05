package me.daniel.sales_taxes_problem;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class OrderItemTest {

	private OrderItem orderItem;
	private SalesTaxStrategy taxStrategy;
	
	@Before
	public void setUp(){
		orderItem = new OrderItem(1, new Product("chocolate", ProductType.FOOD, false, new BigDecimal(12.34)));
		taxStrategy = new BaseSalesTax();
	}
	
	@Test 
	public void testGetters(){
		assertEquals(new Integer(1), orderItem.getQuantity());
		assertEquals(new Product("chocolate", ProductType.FOOD, false, new BigDecimal(12.34)), orderItem.getProduct());
	}
	
	@Test
	public void testToString() {
		String expected = "1 chocolate at 12.34";
		assertEquals(expected, orderItem.toString());
	}
	
	@Test
	public void testEquals() {
		OrderItem same = new OrderItem(1, new Product("chocolate", ProductType.FOOD, false, new BigDecimal(12.34)));
		OrderItem diff1 = new OrderItem(2, new Product("chocolate", ProductType.FOOD, false, new BigDecimal(12.34)));
		OrderItem diff2 = new OrderItem(1, new Product("chocolate2", ProductType.FOOD, false, new BigDecimal(12.34)));
	
		assertTrue(orderItem.equals(same));
		assertFalse(orderItem.equals(diff1));
		assertFalse(orderItem.equals(diff2));
	}
	
	@Test
	public void testGetTotalTax(){
		OrderItem orderItem = new OrderItem (1, new Product("other", ProductType.OTHER, true, new BigDecimal(10.00)));
		BigDecimal expectedTax = new BigDecimal(1.5).setScale(2, BigDecimal.ROUND_HALF_UP);
		
		OrderItem orderItem2 = new OrderItem (2, new Product("other", ProductType.OTHER, true, new BigDecimal(10.00)));
		BigDecimal expectedTax2 = new BigDecimal(3).setScale(2, BigDecimal.ROUND_HALF_UP);
		
		assertEquals(expectedTax, orderItem.getTotalTax(taxStrategy));
		assertEquals(expectedTax2, orderItem2.getTotalTax(taxStrategy));
	}
	
	@Test
	public void testGetTotalNetPrice(){
		OrderItem orderItem = new OrderItem (1, new Product("other", ProductType.OTHER, true, new BigDecimal(10.00)));
		BigDecimal expectedNetPrice = new BigDecimal(10).setScale(2, BigDecimal.ROUND_HALF_UP);
		
		OrderItem orderItem2 = new OrderItem (2, new Product("other", ProductType.OTHER, true, new BigDecimal(10.00)));
		BigDecimal expectedNetPrice2 = new BigDecimal(20).setScale(2, BigDecimal.ROUND_HALF_UP);
		
		assertEquals(expectedNetPrice, orderItem.getTotalNetPrice());
		assertEquals(expectedNetPrice2, orderItem2.getTotalNetPrice());
	}
	
	@Test
	public void testGetTotalPrice(){
		OrderItem orderItem = new OrderItem (1, new Product("other", ProductType.OTHER, true, new BigDecimal(10.00)));
		BigDecimal expectedPrice = new BigDecimal(11.5).setScale(2, BigDecimal.ROUND_HALF_UP);
		
		OrderItem orderItem2 = new OrderItem (2, new Product("other", ProductType.OTHER, true, new BigDecimal(10.00)));
		BigDecimal expectedPrice2 = new BigDecimal(23).setScale(2, BigDecimal.ROUND_HALF_UP);
		
		assertEquals(expectedPrice, orderItem.getTotalPrice(taxStrategy));
		assertEquals(expectedPrice2, orderItem2.getTotalPrice(taxStrategy));
	}

}
