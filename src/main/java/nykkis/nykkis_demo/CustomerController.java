package nykkis.nykkis_demo;

	import javax.faces.application.FacesMessage;
	import javax.faces.bean.ManagedBean;
	import javax.faces.bean.ManagedProperty;
	import javax.faces.context.FacesContext;

	import java.util.List;
	import javax.ejb.EJB;

	@ManagedBean
	public class CustomerController {

		// EJB-komponentti sisältää datan tallennuksen ja haun tietokannasta JPA:lla
		@EJB
		private CustomerEjb customerEjb;

		@ManagedProperty(value = "#{customer}")
		private Customer customer;

		public CustomerController() {
			// bookEjb.alustaBooket();

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

			if (customer.getName().length() > 2 && customer.getEmail().length() > 2)
				customerEjb.save(customer);
			else 
				viesti = "tallennus epäonnistui (nimi/malli väh. 2 merkkiä): " + customer;
			
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

