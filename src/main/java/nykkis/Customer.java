package nykkis;



public class Customer {
	
	 public enum  Status {contact,lead,on_going,customer,old_customer,retired};
		
	
	
	private String name;
	private int customer_id;
	private String phone;
	private String email;
	private String picture;
	private int seler_id;
	private String Address;
	private Status status_id;
	
	
	public Customer(){
		this.name="pekka";
		this.customer_id=1;
		this.phone="09233456";
		this.email="pekka@yahoo.com";
		this.picture="pekka.jpg";
		this.seler_id=02;
		this.Address="pekkalampi 2A10";
		this.status_id=status_id.contact;
		
	 }


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
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


	public String getPicture() {
		return picture;
	}


	public void setPicture(String picture) {
		this.picture = picture;
	}


	public int getSeler_id() {
		return seler_id;
	}


	public void setSeler_id(int seler_id) {
		this.seler_id = seler_id;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public Status getStatus_id() {
		return status_id;
	}


	public void setStatus_id(Status status_id) {
		this.status_id = status_id;
	}


	@Override
	public String toString() {
		return "Customer [name=" + name + ", customer_id=" + customer_id + ", phone=" + phone + ", email=" + email
				+ ", picture=" + picture + ", seler_id=" + seler_id + ", Address=" + Address + ", status_id="
				+ status_id + "]";
	}
	
	
	}


