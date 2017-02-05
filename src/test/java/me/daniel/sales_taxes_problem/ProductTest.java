package me.daniel.sales_taxes_problem;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.*;

public class ProductTest {

	Product product;
	
	@Before
	public void setUp(){
		product = new Product("chocolate", ProductType.FOOD, false, new BigDecimal(12.34));
	}
	
	@Test
	public void testToString() {
		String expected = "name: chocolate, type: FOOD, imported: false, price: 12.34";		
		assertEquals(expected, product.toString());
	}
	
	@Test
	public void testGetters() {
		assertEquals("chocolate", product.getName());
		assertEquals(ProductType.FOOD, product.getProductType());
		assertEquals(false, product.isImported());
		assertEquals(new BigDecimal(12.34).setScale(2, BigDecimal.ROUND_HALF_UP), product.getPrice());
	}
	
	@Test
	public void testEquals(){
		Product same = new Product("chocolate", ProductType.FOOD, false, new BigDecimal(12.34));
		Product diff1 = new Product("chocolat", ProductType.FOOD, false, new BigDecimal(12.34));
		Product diff2 = new Product("chocolate", ProductType.MEDICAL, false, new BigDecimal(12.34));
		Product diff3 = new Product("chocolate", ProductType.FOOD, true, new BigDecimal(12.34));
		Product diff4 = new Product("chocolate", ProductType.FOOD, true, new BigDecimal(12.35));
		Integer diff5 = new Integer(42);
		
		assertTrue(product.equals(same));
		assertFalse(product.equals(diff1));
		assertFalse(product.equals(diff2));
		assertFalse(product.equals(diff3));
		assertFalse(product.equals(diff4));
		assertFalse(product.equals(diff5));

	}

}
