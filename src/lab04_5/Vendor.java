package lab04_5;

import java.util.ArrayList;
import java.util.List;

public class Vendor extends Company {
	private static ObjectManager manager = new ObjectManager();

	public static ObjectManager getManager() {
		return manager;
	}

	// TODO: Association class end
	List<Terms> terms = new ArrayList<Terms>();
	
	public Vendor(String name, String address, String phone, String fax) {
		super(name, address, phone, fax);

		manager.addObject(this);
	}

	public List<Terms> getTerms() {
		return terms;
	}

	public void setTerms(List<Terms> terms) {
		this.terms = terms;
	}

	// TODO: add method
	public void addTerms(Terms term) {
		this.terms.add(term);
	}
}