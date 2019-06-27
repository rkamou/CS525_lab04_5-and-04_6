package lab04_5;

class Company extends DomainObject {
	private static ObjectManager manager = new ObjectManager();

	public static ObjectManager getManager() {
		return manager;
	}

	private String name;
	private String address;
	private String phone;
	private String fax;

	public Company(String name, String address, String phone, String fax) {
		manager.addObject(this);

		this.name = name;
		this.address = address;
		this.phone = phone;
		this.fax = fax;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhone() {
		return phone;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getFax() {
		return fax;
	}
}
