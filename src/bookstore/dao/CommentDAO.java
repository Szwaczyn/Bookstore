package bookstore.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import bookstore.entity.Comment;

public class CommentDAO {

	private EntityManager em;
	
	public CommentDAO(EntityManager em) {
		this.em = em;
	}
	
	public boolean addComment(Comment c) {
		EntityTransaction et = this.em.getTransaction();
		try {
			et.begin();
			em.persist(c);
			et.commit();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			et.rollback();
			return false;
		}
	}
}
