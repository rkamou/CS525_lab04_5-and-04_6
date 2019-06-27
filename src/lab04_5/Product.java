package lab04_5;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Product extends DomainObject {
	private static ObjectManager manager = new ObjectManager();

	public static ObjectManager getManager() {
		return manager;
	}

	private String name;
	private String description;

	// TODO: Association class end
	List<Terms> terms = new ArrayList<Terms>();

	public Product(String name, String description) {
		manager.addObject(this);

		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// TODO: add methods
	public void addTerms(Terms term) {
		terms.add(term);
	}
	
	public Double getMinPrice() {
		return terms.parallelStream().map(e->e.getPrice()).collect(Collectors.summarizingDouble(e->e.doubleValue())).getMin();
	}
	
	public Double getMaxPrice() {
		return terms.parallelStream().map(e->e.getPrice()).collect(Collectors.summarizingDouble(e->e.doubleValue())).getMax();
	}
	
	/*
	 * Example for formatting a number as a Dollar amount:
	 * 
	 * double amount = 3000.0; NumberFormat nf = new DecimalFormat("$0.00");
	 * priceRange = "" + nf.format(amount);
	 */
	public String getPriceRange() {
		String priceRange;
		// TODO: return a string of low - high price range found in terms
		NumberFormat nf = new DecimalFormat("$0.00");
		priceRange = ""+ nf.format(getMinPrice())+" "+ nf.format(getMaxPrice());
		//System.out.println(terms.size());System.out.println(getMinPrice());System.out.println(getMaxPrice());
		return priceRange;
	}

}
