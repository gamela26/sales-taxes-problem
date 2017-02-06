package me.daniel.sales_taxes_problem;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ProductTypeTest {
	
	private ProductType expected;
	private ProductType actual;
	
	public ProductTypeTest(ProductType expected, ProductType actual){
		this.expected = expected;
		this.actual = actual;
	}
	
	@Parameters
	public static Collection<Object[]> data () {
		return Arrays.asList(new Object[][]	{
			{ProductType.BOOKS ,ProductType.getProductType("book")},
			{ProductType.OTHER, ProductType.getProductType("music CD")},
			{ProductType.FOOD, ProductType.getProductType("chocolate bar")},
			{ProductType.FOOD, ProductType.getProductType("imported box of chocolates")},
			{ProductType.OTHER, ProductType.getProductType("imported bottle of perfume")},
			{ProductType.OTHER, ProductType.getProductType("bottle of perfume")},
			{ProductType.MEDICAL, ProductType.getProductType("packet of headache pills")},
			{ProductType.FOOD, ProductType.getProductType("box of imported chocolates")}
		});
	}
	
	@Test
	public void test() {
		assertEquals(expected, actual);
	}

}
