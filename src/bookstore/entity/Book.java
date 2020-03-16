package bookstore.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book implements Serializable {

	@Id
	@GeneratedValue
	private long id;
	@Column(name = "title")
	private String title;
	@Column(name = "author")
	private String author;
	@Column(name="released")
	private Timestamp released;
	
	@OneToMany
	private Set<Comment> comment;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Timestamp getReleased() {
		return released;
	}

	public void setReleased(Timestamp released) {
		this.released = released;
	}

	public Set<Comment> getComment() {
		return comment;
	}

	public void setComment(Set<Comment> comment) {
		this.comment = comment;
	}
	
}
