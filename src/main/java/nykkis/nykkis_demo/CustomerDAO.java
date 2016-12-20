package nykkis.nykkis_demo;

import java.io.Serializable;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Propagation;

@SuppressWarnings("unused")
public class CustomerDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
		
	@PersistenceContext
	private EntityManager em;
	
	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public CustomerDAO() {
		super();
	}

	@SuppressWarnings("unchecked")
	public List<Customer> findAll() {
		List<Customer> cus = (List<Customer>) em.createQuery("select t from Customer t").getResultList();
		return cus;
	}

	@SuppressWarnings("unchecked")
	public List<Customer> findByName(String name) {
		List<Customer> cus = (List<Customer>) em.createQuery("select t from Customer t where t.name=:name")
				.setParameter("name", name).getResultList();
		return cus;
	}

	@SuppressWarnings("unchecked")
	public Customer findById(Integer intId) {
		Long id = new Long(intId);
		Customer cus = (Customer) em.createQuery("select t from Customer t where t.id=:id")
				.setParameter("id", id).getSingleResult();
		return cus;
	}
	
	public Customer save(Customer cus) {
		em.persist(cus);
		return cus;
	}
	
	public Customer update(Customer cus) {
		em.merge(cus);
		return cus;
	}

	public void delete(Customer cus) {
		em.remove(cus);
	}

}


