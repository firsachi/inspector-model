package ua.kiev.inspector.model.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;
import java.util.List;

/**
 * The persistent class for the inspector_users database table.
 * 
 */
@Entity
@Table(name="inspector_users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4055983228326770433L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="users_id")
	private int usersId;

	@Column(name="date")
	private Timestamp date;
	
	@Column(name="enabled")
	private int enabled;
	
	@Column(name="lastname")
	private String lastName;

	@Column(name="mail")
	private String mail;

	@Column(name="name")
	private String firstName;
	
	@Column(name="password")
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(	name = "user_role",
				joinColumns = @JoinColumn(name = "user_id"),
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> userRoles;
	
	public User() {
	}

	public int getUsersId() {
		return usersId;
	}

	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<Role> userRoles) {
		this.userRoles = userRoles;
	}

	
}