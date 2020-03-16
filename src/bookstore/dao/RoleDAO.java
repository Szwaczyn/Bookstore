package bookstore.dao;

import javax.persistence.EntityManager;

import bookstore.entity.Role;

public class RoleDAO {
	
	private EntityManager em;
	
	public RoleDAO(EntityManager em) {
		this.em = em;
	}
	
	public Role getUserRole() {
		Role user = (Role)em.createNativeQuery("SELECT r FROM role r WHERE r.role_name = :role").
		setParameter("role", "user").
		getSingleResult();
		
		return user;
	}
}
