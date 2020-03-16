package bookstore.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import bookstore.entity.*;

import javax.persistence.*;

@Entity
@Table(name="comment")
public class Comment implements Serializable {

	@Id
	@GeneratedValue
	private int id;
	@Column(name="content")
	private String content;
	@Column(name="timestamp")
	private Timestamp timestamp;
	
	@ManyToOne
	@JoinColumn(name="user")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="book")
	private Book book;
	
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
}
