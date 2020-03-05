package bookstore.dao;

import java.util.List;
import bookstore.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserDAO {

	private EntityManager em;
	
	public UserDAO(EntityManager em) {
		this.em = em;
	}
	
	public List<User> getUsers() {
		List<User> users = this.em.createQuery("SELECT u FROM User u").getResultList();
		return users;
	}
		
	public User getUser(int id) {
		this.em.clear();
		return this.em.find(User.class, id);
	}
	
	public boolean addUser(User u) {
		EntityTransaction et = em.getTransaction();
		
		try {
			et.begin();
			em.persist(u);
			et.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			et.rollback();
			return false;
		}
	}
}
