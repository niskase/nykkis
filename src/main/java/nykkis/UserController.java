package nykkis;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

	import java.util.List;

import javax.ejb.EJB;

	@ManagedBean
	public class UserController {
		// olio sisältää datan tallennuksen ja haun tietokannasta JPA:lla
		@EJB
		private ProjectEJB userEjb;

		@ManagedProperty(value = "#{user}")
		private User user;

		public UserController() {

		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public String save() {
			
			String viesti = "Tallennus onnistui: " + user;

			FacesContext facesContext = FacesContext.getCurrentInstance();

			userEjb.save(user);
			
			FacesMessage facesMessage = new FacesMessage(viesti);
			facesContext.addMessage(null, facesMessage);

			return "index";
		}

		public List<User> getUsers() {
			return userEjb.getUsers();
		}

		public String initialize() {
			userEjb.init();
			return null;
		}
	}

