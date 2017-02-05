package me.daniel.sales_taxes_problem;

import static org.junit.Assert.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class FileImportTest {
	
	private List<OrderItem> imported;
	private List<OrderItem> expected;
	
	public FileImportTest(List<OrderItem> imported, List<OrderItem> expected){
		this.imported = imported;
		this.expected = expected;
	}
	
	@Parameters
	public static Collection<Object[]> data () throws IOException {
					
		CartImportStrategy importStrategy = new CartFileImporter();
		List<OrderItem> cart1 = new LinkedList<OrderItem>();	
		List<OrderItem> cart2 = new LinkedList<OrderItem>();	
		List<OrderItem> cart3 = new LinkedList<OrderItem>();

		cart1.add(new OrderItem(1, new Product("book",ProductType.BOOKS, false, new BigDecimal(12.49))));
		cart1.add(new OrderItem(1,new Product("music CD",ProductType.OTHER, false, new BigDecimal(14.99))));
		cart1.add(new OrderItem(1,new Product("chocolate bar",ProductType.FOOD, false, new BigDecimal(0.85))));
		
		cart2.add(new OrderItem(1,new Product("imported box of chocolates",ProductType.FOOD, true, new BigDecimal(10.00))));
		cart2.add(new OrderItem(1,new Product("imported bottle of perfume",ProductType.OTHER, true, new BigDecimal(47.50))));

		cart3.add(new OrderItem(1,new Product("imported bottle of perfume",ProductType.OTHER, true, new BigDecimal(27.99))));
		cart3.add(new OrderItem(1,new Product("bottle of perfume",ProductType.OTHER, false, new BigDecimal(18.99))));
		cart3.add(new OrderItem(1,new Product("packet of headache pills",ProductType.MEDICAL, false, new BigDecimal(9.75))));
		cart3.add(new OrderItem(1,new Product("box of imported chocolates",ProductType.FOOD, true, new BigDecimal(11.25))));
		
		return Arrays.asList(new Object[][]	{
			{importStrategy.importCart("files/cart1.txt"), cart1 },
			{importStrategy.importCart("files/cart2.txt"), cart2 },
			{importStrategy.importCart("files/cart3.txt"), cart3 }
		});
	}	
	
	@Test
	public void test(){
		assertEquals(expected, imported);
	}
}
