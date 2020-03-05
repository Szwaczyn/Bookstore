package bookstore.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="book")

public class Book implements Serializable{
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String author;
	private Timestamp released;
	
	@OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
	// @OrderBy("date ASC")
	private Set<Comment> comment;
	
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getReleased() {
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
