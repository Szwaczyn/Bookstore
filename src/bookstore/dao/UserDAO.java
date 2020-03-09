package bookstore.dao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import bookstore.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.xml.bind.DatatypeConverter;

public class UserDAO {

	private EntityManager em;
	
	public UserDAO(EntityManager em) {
		this.em = em;
	}
	
	public List<User> getUser() {
		List<User> users = this.em.createQuery("SELECT u FROM User u").getResultList();
		return users;
	}
		
	public User getUser(int id) {
		this.em.clear();
		return this.em.find(User.class, id);
	}
	
	public User getUser(String login) {
		User user = (User)em.createQuery("SELECT u FROM user u WHERE u.login = :login")
				.setParameter("login", login)
				.getSingleResult();
		
		return user;
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
	
	private String getMD5(String string) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(string.getBytes());
		    String hashedString = DatatypeConverter
		    	      .printHexBinary(md.digest()).toUpperCase();
		    return hashedString;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
