package nykkis;
	//JPA:n vaatimat kirjastojen importtaukset
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import javax.ejb.Stateless;

import nykkis.Customer.status;
import nykkis.User.role;

@Stateless
public class CustomerEjb {
	
	
	@PersistenceContext(unitName = "jpa_nykkis") // Check persistence.xml
	private EntityManager em;

	public CustomerEjb() {

	}
	
	public void init() {
		
		User user = new User();
		user.setUserid(1);
		user.setUsername("admin");
		user.setPassword("pass");
		user.setRole(role.ADMIN);
		user.setLoginstatus(0); 
		
		em.persist(user);
		
		Customer customer = new Customer();
		customer.setCustomerid(1);
		customer.setUserid(1);
		customer.setCustomername("Customer");
		customer.setCustomerphone("0000000000");
		customer.setCustomeremail("customer@mail.com");
		customer.setCustomerphoto(null);
		customer.setCustomercountry("Finland");
		customer.setCustomersellerresp(null);
		customer.setCustomeraddress("Jokelantie 1");
		customer.setCustomercity("Jyväskylä");
		customer.setCustomerstatus(status.contact);
		
		System.out.println("saved customer: " + customer);
		
		em.persist(customer);
		
	}


	public void save(Customer customer) {
		try {
			em.persist(customer);
			System.out.println("save a customer: " + customer);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Not saved!");
		}
	}
	
	public void save(User user) {
		try {
			em.persist(user);
			System.out.println("save an user: " + user);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Not saved!");
		}
	}

	
	@SuppressWarnings("unchecked")
	public List<Customer> getCustomers() {
		List<Customer> customers= null; 
		customers = em.createNamedQuery("searchAllCustomers").getResultList();
		System.out.println("All customers: " + customers);
		return customers;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		List<User> users= null; 
		users = em.createNamedQuery("searchAllUsers").getResultList();
		System.out.println("All users: " + users);
		return users;
	}


}