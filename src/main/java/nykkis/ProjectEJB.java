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
		
		User user1 = new User();
		user1.setUserid(1);
		user1.setUsername("admin");
		user1.setPassword("pass");
		user1.setRole(role.ADMIN);
		user1.setLoginstatus(0); 
		
		em.persist(user1);
		
		Customer customer1 = new Customer();
		customer1.setCustomerid(1);
		customer1.setUserid(1);
		customer1.setCustomername("Customer");
		customer1.setCustomerphone("0000000000");
		customer1.setCustomeremail("customer@mail.com");
		customer1.setCustomerphoto(null);
		customer1.setCustomercountry("Finland");
		customer1.setCustomersellerresp(null);
		customer1.setCustomeraddress("Jokelantie 1");
		customer1.setCustomercity("Jyväskylä");
		customer1.setCustomerstatus(status.contact);
		
		em.persist(customer1);
		
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