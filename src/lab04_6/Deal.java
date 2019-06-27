package lab04_6;

class Deal
{
	private static int currentNumber = 1;
	private static int getNextNumber() { return currentNumber++; }

	private int number;
	
	// TODO: Implement ternary association ends
	Product product;
	SalesConsultant salesConsultant;
	Customer customer;
	

	public Deal(Product product, SalesConsultant salesConsultant, Customer customer) {
		number = getNextNumber();
		
		// TODO: Instantiate ternary association 
		this.product = product;
		this.product.addDeal(this);
		
		this.salesConsultant = salesConsultant;
		this.salesConsultant.addDeal(this);
		this.customer = customer;
		this.customer.addDeal(this);
	}

	public int getNumber() { return number; }
	
	public void show()
	{
		System.out.println("Deal #" + number + ": ");
		
		// TODO: Print out name of each related object
		System.out.println("  "+"Product :" + this.product.getName());
		System.out.println("  "+"Customer : "+ this.customer.getName());
		System.out.println("  "+"Sales Consultant : "+ this.salesConsultant.getName());
		
		System.out.println();
	}
}
