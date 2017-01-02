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
	private static final long serialVersionUID = 2L;


	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long userid;
	@Column(unique=true)
	private String username;
	private String password;
	
	//enumi
	public enum role {
		seller, servicer, biller, boss, admin
	}
	
	private role role;
	
	private int loginstatus; 

	//Constructor superclass
	public User() {
		super();
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

	public int getLoginstatus() {
		return loginstatus;
	}

	public void setLoginstatus(int loginstatus) {
		this.loginstatus = loginstatus;
	}

	public role getRole() {
		return role;
	}

	public void setRole(role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username
				+ ", password=" + password + ", role=" + role
				+ ", loginstatus=" + loginstatus + "]";
	}
	
}
