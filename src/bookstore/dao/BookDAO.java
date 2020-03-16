package bookstore.dao;

import java.util.List;
import bookstore.entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class BookDAO {
	
	private EntityManager em;
	
	public BookDAO(EntityManager entityManager) {
		this.em = entityManager;
	}
	
	public List<Book> getBook(){
		List<Book> resultBook = this.em.createQuery("SELECT b FROM book b").getResultList();
		return resultBook;
	}
	
	public Book getBook(long idBook) {
		this.em.clear();
		return this.em.find(Book.class, idBook);
	}
	
	public boolean createBook(Book book) {
		EntityTransaction et = this.em.getTransaction();
		try {
			et.begin();
			em.persist(book);
			et.commit();
			return true;
		}catch (Exception e) {
			et.rollback();
			e.printStackTrace();
			return false;
		}
	}
}
