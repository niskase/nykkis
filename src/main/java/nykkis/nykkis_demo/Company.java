package nykkis.nykkis_demo;

public class Company {
	
	private String name;
	private String phone;
	private String email;
	private String address;
	private String website;
	private int customer_id;
	private int buisness_id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getBuisness_id() {
		return buisness_id;
	}
	public void setBuisness_id(int buisness_id) {
		this.buisness_id = buisness_id;
	}
	@Override
	public String toString() {
		return "Company [name=" + name + ", phone=" + phone + ", email=" + email + ", address=" + address + ", website="
				+ website + ", customer_id=" + customer_id + ", buisness_id=" + buisness_id + "]";
	}
	
	
	

}
