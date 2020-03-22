package bookstore.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "Role")
public class Role implements Serializable {

	@Id
	@GeneratedValue
	private long id;
	@Column(name = "roleName")
	private String roleName;
	
	@OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
	private Set<User> user;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

}
