package nykkis;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

	import java.util.List;

import javax.ejb.EJB;

	@ManagedBean
	public class CustomerController {

		@EJB
		private ProjectEJB customerEjb;

		@ManagedProperty(value = "#{customer}")
		private Customer customer;

		public CustomerController() {

		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		public String saveCustomer() {
			
			String viesti = "Tallennus onnistui: " + customer;

			FacesContext facesContext = FacesContext.getCurrentInstance();

			customerEjb.saveCustomer(customer);
			
			FacesMessage facesMessage = new FacesMessage(viesti);
			facesContext.addMessage(null, facesMessage);

			return "index";
		}
		
		//user deleting
				public void deleteCustomer(Customer c) {
					
					long customerid = c.getCustomerid();
					
					customerEjb.deleteCustomer(customerid);
				}

		public List<Customer> getCustomers() {
			return customerEjb.getCustomers();
		}

		public void init() {
			customerEjb.init();
		}
	}

