package bookstore.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class Comment {

	@Id
	private int id;
	private String author;
	private String content;
	private int book_ID;
	
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
	public int getBook_ID() {
		return book_ID;
	}
	public void setBook_ID(int book_ID) {
		this.book_ID = book_ID;
	}
}
