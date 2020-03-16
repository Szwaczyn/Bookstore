package bookstore.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User implements Serializable{
	
	@Id
	@GeneratedValue
	private int id;
	@Column(name = "login")
	private String login;
	@Column(name = "password")
	private String password;
	
	@ManyToOne
	@JoinColumn(name="role")
	private Role role;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}


}
