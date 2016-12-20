package nykkis.nykkis_demo;

public class Contact {
	private int customer_id;
	private int seller_id;
	private String contact_method;
	private String comment;
	public int getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}
	public int getSeller_id() {
		return seller_id;
	}
	public void setSeller_id(int seller_id) {
		this.seller_id = seller_id;
	}
	public String getContact_method() {
		return contact_method;
	}
	public void setContact_method(String contact_method) {
		this.contact_method = contact_method;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "Contact [customer_id=" + customer_id + ", seller_id=" + seller_id + ", contact_method=" + contact_method
				+ ", comment=" + comment + "]";
	}
	
	
}
