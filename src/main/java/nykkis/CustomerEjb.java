package nykkis;
	//JPA:n vaatimat kirjastojen importtaukset
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import javax.ejb.Stateless;

@Stateless
public class CustomerEjb {
	
	
	@PersistenceContext(unitName = "jpa_nykkis") // Check persistence.xml
	private EntityManager em;

	public CustomerEjb() {

	}
	
	public void init() {
		Customer c= new Customer();
		

		//System.out.println("saved customer: " + c);
		em.persist(c);
		
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

	
	@SuppressWarnings("unchecked")
	public List<Customer> getCustomers() {
		List<Customer> Customers= null; 
		Customers = em.createNamedQuery("searchAllCustomers").getResultList();
		System.out.println("*********** search all ********** => " + Customers);
		return Customers;
	}


}