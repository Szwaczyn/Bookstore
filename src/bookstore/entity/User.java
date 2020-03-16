package bookstore.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User implements Serializable {

	@Id
	@GeneratedValue
	private long id;
	@Column(name = "login")
	private String login;
	@Column(name = "password")
	private String password;
	@Column(name = "display_name")
	private String displayName;
	
	@OneToMany(mappedBy="user")
	private Set<Comment> comment;
	
	@ManyToOne
	@JoinColumn(name="role")
	private Role role;

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public long getId() {
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

	public Set<Comment> getComment() {
		return comment;
	}

	public void setComment(Set<Comment> comment) {
		this.comment = comment;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}
