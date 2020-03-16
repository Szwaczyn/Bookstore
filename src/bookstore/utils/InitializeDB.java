package bookstore.utils;

import javax.persistence.EntityManager;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import bookstore.dao.UserDAO;

/**
 * Application Lifecycle Listener implementation class InitializeDB
 *
 */
@WebListener
public class InitializeDB implements ServletRequestListener {

    public InitializeDB() {
        // TODO Auto-generated constructor stub
    }

    public void requestDestroyed(ServletRequestEvent sre)  { 
         // TODO Auto-generated method stub
    }

    public void requestInitialized(ServletRequestEvent sre)  { 
         EntityManager em = DBConfig.createEntityManager();
         
         UserDAO userDAO = new UserDAO(em);
         
         ServletRequest req = sre.getServletRequest();
         req.setAttribute("UserDAO", userDAO);
    }
	
}
