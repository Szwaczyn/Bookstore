package bookstore.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="comment")
public class Comment implements Serializable{

	@Id
	@GeneratedValue
	private int id;
	private String author;
	@Lob() 
	private String content;
	
	@ManyToOne
	@JoinColumn(name="book")
	private Book book;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
}
