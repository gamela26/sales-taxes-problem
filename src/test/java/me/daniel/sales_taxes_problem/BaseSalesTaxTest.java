package me.daniel.sales_taxes_problem;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


@RunWith(Parameterized.class)
public class BaseSalesTaxTest {

	private SalesTaxStrategy salesTax;
	private Product product;
	private BigDecimal expected;
	
	public BaseSalesTaxTest(Product product, BigDecimal expected){
		this.product = product;
		this.expected = expected;
	}
	
	@Parameters
	public static Collection<Object[]> data () {
		return Arrays.asList(new Object[][]	{
			{new Product("p1",1, ProductType.BOOKS, false, new BigDecimal(12.49)), new BigDecimal(0)}, 
			{new Product("p2",1, ProductType.OTHER, false, new BigDecimal(14.99)), new BigDecimal(1.5)}, 
			{new Product("p3",1, ProductType.FOOD, false, new BigDecimal(0.85)), new BigDecimal(0)},
			
			{new Product("p4",1, ProductType.FOOD, true, new BigDecimal(10.00)), new BigDecimal(0.50)}, 
			{new Product("p5",1, ProductType.OTHER, true, new BigDecimal(47.50)), new BigDecimal(7.15)},
			
			{new Product("p6",1, ProductType.OTHER,	true, new BigDecimal(27.99)), new BigDecimal(4.20)},
			{new Product("p7",1, ProductType.OTHER, false, new BigDecimal(18.99)), new BigDecimal(1.90)}, 
			{new Product("p8",1, ProductType.MEDICAL, false, new BigDecimal(9.75)), new BigDecimal(0)},
			{new Product("p9",1, ProductType.FOOD, true, new BigDecimal(11.25)), new BigDecimal(0.60)}
		});
	}	
		
	@Before
	public void setUp() throws Exception {
		salesTax = new BaseSalesTax();
	}

	@Test
	public void test() {
		BigDecimal tax = salesTax.apply(product);
		expected = 	expected.setScale(2, BigDecimal.ROUND_HALF_UP);
		assertEquals(expected, tax);
	}
	
}
