package bookstore.dao;

import java.util.List;

import bookstore.entity.Book;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class BookDAO {

	private EntityManager em;
	
	public BookDAO(EntityManager em) {
		this.em = em;
	}
	
	public List<Book> getBooks(){
		List<Book> books = this.em.createQuery("SELECT b FROM Book b").getResultList();
		return books;
	}
	
	public Book getBook(int id) {
		return em.find(Book.class, id);
	}
	
	public boolean addBook(Book book) {
		EntityTransaction et = this.em.getTransaction();
		try {
			et.begin();
			em.persist(book);
			et.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			et.rollback();
			return false;
		}
	}
}
