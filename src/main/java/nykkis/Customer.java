package nykkis;

import java.io.Serializable;

import javax.persistence.*;
import javax.faces.bean.*;
import javax.validation.*;

@ManagedBean
@RequestScoped
@Entity
@NamedQuery(name = "searchAllCustomers", query = "SELECT c from Customer c")
public class Customer implements Serializable {
	
	public enum status {contact,lead,on_going,customer,old_customer,retired};
	
	@Id
	@SequenceGenerator(name = "customersequence", sequenceName = "CUSTOMER_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customersequence")
	private long customerid;
	private long userid;
	private String customername;
	private String customerphone;
	private String customeremail;
	private String customerphoto;
	private String customercountry;
	private String customersellerresp;
	private String customeraddress;
	private String customercity;
	private status customerstatus;
	
	//constructor
	public Customer() {
	}
	
	//getters and setters

	public long getCustomerid() {
		return customerid;
	}

	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getCustomerphone() {
		return customerphone;
	}

	public void setCustomerphone(String customerphone) {
		this.customerphone = customerphone;
	}

	public String getCustomeremail() {
		return customeremail;
	}

	public void setCustomeremail(String customeremail) {
		this.customeremail = customeremail;
	}

	public String getCustomerphoto() {
		return customerphoto;
	}

	public void setCustomerphoto(String customerphoto) {
		this.customerphoto = customerphoto;
	}

	public String getCustomercountry() {
		return customercountry;
	}

	public void setCustomercountry(String customercountry) {
		this.customercountry = customercountry;
	}

	public String getCustomersellerresp() {
		return customersellerresp;
	}

	public void setCustomersellerresp(String customersellerresp) {
		this.customersellerresp = customersellerresp;
	}

	public String getCustomeraddress() {
		return customeraddress;
	}

	public void setCustomeraddress(String customeraddress) {
		this.customeraddress = customeraddress;
	}

	public String getCustomercity() {
		return customercity;
	}

	public void setCustomercity(String customercity) {
		this.customercity = customercity;
	}

	public status getCustomerstatus() {
		return customerstatus;
	}

	public void setCustomerstatus(status customerstatus) {
		this.customerstatus = customerstatus;
	}

	//tostring
	
	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", userid=" + userid
				+ ", customername=" + customername + ", customerphone="
				+ customerphone + ", customeremail=" + customeremail
				+ ", customerphoto=" + customerphoto + ", customercountry="
				+ customercountry + ", customersellerresp="
				+ customersellerresp + ", customeraddress=" + customeraddress
				+ ", customercity=" + customercity + ", customerstatus="
				+ customerstatus + "]";
	}
	
	}


