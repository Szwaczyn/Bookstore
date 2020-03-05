package bookstore.dao;

import java.util.List;

import bookstore.entity.Role;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class RoleDAO {
	
	private EntityManager em;
	
	public RoleDAO(EntityManager em) {
		this.em = em;
	}
	
	public List<Role> getRoles(){
		List<Role> roles = this.em.createQuery("SELECT r FROM Role r").getResultList();
		return roles;
	}
	
	public Role getRole(int id) {
		this.em.clear();
		return this.em.find(Role.class, id);
	}
	
	public boolean addRole(Role role) {
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(role);
			et.commit();
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			et.rollback();
			return false;
		}
	}
}
