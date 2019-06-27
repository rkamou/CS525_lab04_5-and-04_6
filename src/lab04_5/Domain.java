package lab04_5;

import java.util.Vector;

class Domain {
	private Product[] products;
	private Vendor[] vendors;

	// Package visible
	Domain() {
		createDomainObjects();
	}

	private void createDomainObjects() {
		Product[] p = { new Product("Laptop 2001", "400 MB RAM - 750 MHZ - 15 GB"),
				new Product("Dell Latitude", "220 MB RAM - 350 MHZ - 10 GB"),
				new Product("Desktop 9801", "650 MB RAM - 900 MHZ - 30 GB - Linux"),
				new Product("HP 8100 DN", "Duplex installed - Network ready") };
		products = p;

		Vendor[] v = { new Vendor("Gateway Outlet", "1245 Parkway Dr.", "(320) 567 9987", "(320) 977 0889"),
				new Vendor("Net Office", "134 South Michigan Ave.", "(312) 755 8998", "(312 933 8008)"),
				new Vendor("Sam's Roads", "205 North Monroe", "(312) 765 9778", "(312) 734 9557"),
				new Vendor("Ben & Jenny's", "134 North Jefferson", "(617) 456 9878", "(617) 234 0478") };
		vendors = v;

		Terms[] t = { new Terms(v[0], p[0], 6500.00, "Overnight", "30 days"),
				new Terms(v[3], p[0], 6700.00, "2-day", "15 days"),
				new Terms(v[1], p[0], 6300.00, "3-day", "No refund"),
				new Terms(v[0], p[1], 6500.00, "Overnight", "30 days"),
				new Terms(v[2], p[1], 6100.00, "3-day", "60 days"),
				new Terms(v[1], p[2], 6500.00, "Overnight", "20 days"),
				new Terms(v[2], p[2], 6200.00, "3-day", "No refund"),
				new Terms(v[3], p[2], 6350.00, "5-day", "45 days"),
				new Terms(v[0], p[3], 6500.00, "Overnight", "1 Year") };

	}

	public Vector getProducts() {
		return Product.getManager().getAll();
	}

	public Vector getVendors() {
		return Vendor.getManager().getAll();
	}

	public Vector getTerms() {
		return Terms.getManager().getAll();
	}
}