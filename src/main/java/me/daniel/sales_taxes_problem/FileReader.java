package me.daniel.sales_taxes_problem;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;


public class FileReader {

	private Function<String,Product> func = (str) -> {
		
		String regex   = "(\\d+)\\s(imported\\s)?(.*)\\sat\\s(\\d+\\.\\d+?)";
	    Pattern p  = Pattern.compile(regex);
	    Matcher  m   = p.matcher(str);
		
	    if (m.matches()) {
			Integer qty   = Integer.parseInt(m.group(1));
			Boolean imported = m.group(2)!=null;
			String name = m.group(3);
			BigDecimal price  = new BigDecimal(m.group(4));
			  
			return new Product(name, qty, ProductType.OTHER, imported, price);
	    	  
	    }else{
	    	return null;
	    }
	};
	
	public void start(){
		Path path = Paths.get("files/cart1.txt");
		
		try (Stream<String> stream = Files.lines(path)) {		    
			stream
		    .map(func)
		    .forEach(p->System.out.println(p));
		    
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public static void main(String[] args){ 
		FileReader fr = new FileReader();
		fr.start();
	}
}

