package bookstore.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role implements Serializable {

	@Id
	@GeneratedValue
	private long id;
	@Column(name = "roleName")
	private String roleName;

	@OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
	private Set<User> user;

	private String userName;

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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
