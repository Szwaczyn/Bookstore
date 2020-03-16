package bookstore.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.transaction.Transaction;

import bookstore.entity.Role;

public class RoleDAO {
	
	private EntityManager em;
	
	public RoleDAO(EntityManager em) {
		this.em = em;
	}
	
	public Role getUserRole() {
		try {
			Role user = (Role)em.createNativeQuery("SELECT r FROM role r WHERE r.role_name = :role").
			setParameter("role", "user").
			getSingleResult();
			return user;
		}catch(Exception nre) {
			Role newUserRole = new Role();
			newUserRole.setRoleName("user");
			
			if(this.createRole(newUserRole)) {
				return newUserRole;
			} else {
				return null;
			}
			
		}
	}
	
	public boolean createRole(Role role) {
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(role);
			et.commit();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			et.rollback();
			return false;
		}
	}
}
