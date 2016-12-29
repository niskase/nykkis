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

		public String save() {
			
			String viesti = "Tallennus onnistui: " + customer;

			FacesContext facesContext = FacesContext.getCurrentInstance();

			customerEjb.save(customer);
			
			FacesMessage facesMessage = new FacesMessage(viesti);
			facesContext.addMessage(null, facesMessage);

			return "index";
		}

		public List<Customer> getCustomers() {
			return customerEjb.getCustomers();
		}

		public String initialize() {
			customerEjb.init();
			return null;
		}
	}

