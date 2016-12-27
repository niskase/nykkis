package nykkis;

import java.io.Serializable;

import javax.persistence.*;
import javax.faces.bean.*;

@ManagedBean
@RequestScoped
@Entity
@NamedQuery(name = "searchAllUsers", query = "SELECT u from User u")

public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 10000L;
	
	public enum role {
		SELLER, SERVICER, BILLER, BOSS, ADMIN
	}
	
	@Id
	@SequenceGenerator(name = "usersequence", sequenceName = "USER_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usersequence")
	private long userid;
	private String username;
	private String password;
	private role role;
	private int loginstatus; 

	//Constructor superclass
	public User () {
		
	}

	// Getters & setters
	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getLoginstatus() {
		return loginstatus;
	}

	public void setLoginstatus(int loginstatus) {
		this.loginstatus = loginstatus;
	}

	//To string
	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username
				+ ", password=" + password + ", role=" + role
				+ ", loginstatus=" + loginstatus + "]";
	}
	
}
