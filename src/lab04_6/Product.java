package lab04_6;

import java.util.ArrayList;
import java.util.List;

public class Product
{
	private String name;
	private String description;
	private List<Deal> deals = new ArrayList<Deal>();

	public Product(String name, String description)
	{
		this.name = name;
		this.description = description;
	}
	
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }

	public String getDescription() { return description; }
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public void addDeal(Deal deal) {
		deals.add(deal);
	}
	
	public void show()
	{
		System.out.println("Product: " + name);
		System.out.println("  Deals: "+deals.size());

		// TODO: Print each deal's number
		deals.stream().forEach(e->System.out.print("    "+e.getNumber()+ "  "));
		
		System.out.println();
		System.out.println();
	}
}
