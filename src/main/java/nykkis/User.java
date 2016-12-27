package nykkis;

import java.util.ArrayList;
import java.util.List;

public class User {
	private static enum Roles {admin, seller, boss};
	
	private int user_id;
	private String user_name;
	private String passwd;
	private int login_status; 
	private Roles role;
	
	
	
	public void addCustomer(Customer cus){
	//	if(role == Roles.admin || role == Roles.seller)
			
			ArrayList<Customer> customers = new ArrayList();
			
		
	}
	
	public void removeCustomer(){
		
		
	}
	
	public void addCompany(){
		
	}
	
	public void removeCompany(){
		
	}
	
	public void sentMessageToAdmin(){
		
	}
	
	public void setCustomerStatus(){
		
	}

}
