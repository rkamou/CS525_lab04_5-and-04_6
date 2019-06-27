package lab04_5;

public class Terms extends DomainObject {
	private static ObjectManager manager = new ObjectManager();

	public static ObjectManager getManager() {
		return manager;
	}

	private double price;
	private String delay;
	private String refund;

	// TODO: Association ends

	Vendor vendor;
	Product product;
	
	public Terms(Vendor vendor, Product product, double price, String delay, String refund) {
		

		this.price = price;
		this.delay = delay;
		this.refund = refund;

		// TODO: Create links between this link object and Vendor & Product
		this.vendor = vendor;
		this.vendor.addTerms(this);
		
		this.product = product;
		this.product.addTerms(this);
		
		manager.addObject(this);

	}
	
	public Terms(Vendor vendor, Product product) {
		manager.addObject(this);
		
		this.vendor = vendor;
		this.product = product;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDelay() {
		return delay;
	}

	public void setDelay(String delay) {
		this.delay = delay;
	}

	public String getRefund() {
		return refund;
	}

	public void setRefund(String refund) {
		this.refund = refund;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}