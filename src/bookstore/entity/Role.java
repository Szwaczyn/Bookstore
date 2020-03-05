package bookstore.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;
@Entity
@Table(name="role")
public class Role implements Serializable{

	@Id
	private int id;
	private String name;
	
	@OneToMany(mappedBy="role", fetch = FetchType.EAGER)
	private Set<User> user;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<User> getUser() {
		return user;
	}
	public void setUser(Set<User> user) {
		this.user = user;
	}
	
	
}
