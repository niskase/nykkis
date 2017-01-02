package nykkis;
	//JPA:n vaatimat kirjastojen importtaukset
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import javax.ejb.Stateless;

import nykkis.Customer.status;
import nykkis.User.role;

@Stateless
public class ProjectEJB {
	
	
	@PersistenceContext(unitName = "jpa_nykkis") // Check persistence.xml
	private EntityManager em;
	
	public ProjectEJB() {

	}
	
	public void init() {
		
		User testuser = new User();
		testuser.setUserid(1);
		testuser.setUsername("admin");
		testuser.setPassword("pass");
		testuser.setRole(role.admin);
		testuser.setLoginstatus(0); 
		
		em.persist(testuser);
		
		Customer testcustomer = new Customer();
		testcustomer.setCustomerid(1);
		testcustomer.setUserid(1);
		testcustomer.setCustomername("Customer");
		testcustomer.setCustomerphone("0000000000");
		testcustomer.setCustomeremail("customer@mail.com");
		testcustomer.setCustomerphoto(null);
		testcustomer.setCustomercountry("Finland");
		testcustomer.setCustomersellerresp(null);
		testcustomer.setCustomeraddress("Jokelantie 1");
		testcustomer.setCustomercity("Jyväskylä");
		testcustomer.setCustomerstatus(status.contact);
		
		em.persist(testcustomer);
		
	}

	//save customer
	public void saveCustomer(Customer customer) {
		try {
			em.persist(customer);
			System.out.println("save a customer: " + customer);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Not saved!");
		}
	}
	//delete customer
	public void deleteCustomer(long customerid) {
		try {
			Customer deleteCustomer = em.find(Customer.class, customerid);
			em.remove(deleteCustomer);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Not deleted");
		}
	}
	
	//save user
	public void saveUser(User user) {
		try {
			em.persist(user);
			System.out.println("save an user: " + user);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Not saved!");
		}
	}
	
	//delete user
	public void deleteUser(long userid) {
		try {
			User delete = em.find(User.class, userid);
			em.remove(delete);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Not deleted");
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Customer> getCustomers() {
		List<Customer> customers= null; 
		customers = em.createNamedQuery("searchAllCustomers").getResultList();
		System.out.println("All customers: " + customers);
		return customers;
	}
	
	// get all users
	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		List<User> users= null; 
		users = em.createNamedQuery("searchAllUsers").getResultList();
		System.out.println("All users: " + users);
		return users;
	}


}