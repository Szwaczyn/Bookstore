package bookstore.dao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import bookstore.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
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
	
	public User getUser(String login) throws NoResultException {
		try {
			User user = (User)em.createQuery("SELECT u FROM user u WHERE u.login = :login").
					setParameter("login", login).
					getSingleResult();
			
			return user;
		}catch(Exception e) {
			return null;
		}
	}
	
	public boolean addUser(User u) {
		EntityTransaction et = em.getTransaction();
		
		u.setPassword(this.getMD5(u.getPassword()));
		
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
		    BigInteger hashed = new BigInteger(1, md.digest());
		    String hashedString = hashed.toString(16);
		    
		    if(hashedString.length() == 31) {
		    	hashedString = "0" + hashedString;
		    }
		    
		    return hashedString;
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
