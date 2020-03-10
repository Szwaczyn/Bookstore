package bookstore.utils;

import javax.persistence.EntityManager;
import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

import bookstore.dao.BookDAO;
import bookstore.dao.CommentDAO;
import bookstore.dao.RoleDAO;
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
         
         BookDAO bookDAO = new BookDAO(em);
         CommentDAO commentDAO = new CommentDAO(em);
         RoleDAO roleDAO = new RoleDAO(em);
         UserDAO userDAO = new UserDAO(em);
         
         ServletRequest req = sre.getServletRequest();
         req.setAttribute("bookDAO", bookDAO);
         req.setAttribute("commentDAO", commentDAO);
         req.setAttribute("roleDAO", roleDAO);
         req.setAttribute("userDAO", userDAO);
    }
	
}
