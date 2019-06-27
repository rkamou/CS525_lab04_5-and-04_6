package lab04_6;

public class Application
{
	public static void main(String args[])
	{
		SalesConsultant john = new SalesConsultant("John Smith", 
				"(312) 345 9378");
		
		Customer ibm = new Customer("IBM", "Bill Smith", 
				"1245 Parkway Dr, Chicago, IL 60685", "312 467 9899", 
				"312 467 9890");
		
		Product laptop = new Product("Laptop 2001", 
				"400 MB RAM - 750 MHZ - 15 GB");
		
		Product desktop = new Product("Desktop 9801", 
				"650 MB RAM - 900 MHZ - 30 GB - Linux");
		
		Product latitude = new Product("Dell Latitude", 
				"220 MB RAM - 350 MHZ - 10 GB");
		
		Deal deal1 = new Deal(laptop,john,ibm);
		Deal deal2 = new Deal(desktop,john,ibm);
		Deal deal3 = new Deal(latitude,john,ibm);
		
		deal1.show();
		deal2.show();
		deal3.show();
		
		ibm.show();
		john.show();
		laptop.show();
		desktop.show();
		latitude.show();
	}
}
