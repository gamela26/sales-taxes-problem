package me.daniel.sales_taxes_problem;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

public class OrderItemTest {

	private OrderItem orderItem;
	
	@Before
	public void setUp(){
		orderItem = new OrderItem(1, new Product("chocolate", ProductType.FOOD, false, new BigDecimal(12.34)));
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

}
