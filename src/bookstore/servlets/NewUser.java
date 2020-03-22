package bookstore.servlets;

import java.io.IOException;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookstore.dao.RoleDAO;
import bookstore.dao.UserDAO;
import bookstore.entity.Role;
import bookstore.entity.User;

/**
 * Servlet implementation class NewUser
 */
@WebServlet("/newuser")
public class NewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		
		if(!"".equals(login) && !"".equals(password) && !"".equals(password2) && password.equals(password2) && login != null && password != null){
			User newUser = new User();
			RoleDAO roleDAO = (RoleDAO)request.getAttribute("RoleDAO");
			Role role = roleDAO.getUserRole();
			
			newUser.setLogin(login);
			newUser.setPassword(password);
			newUser.setRole(role);
			
			UserDAO userDAO = (UserDAO)request.getAttribute("UserDAO");
			if(userDAO.getUser(login) != null) {
				request.setAttribute("error", "User already exist!");
				this.doGet(request, response);
			} else {
				if (userDAO.addUser(newUser) ) {
					request.setAttribute("error", "User wass added");
					this.doGet(request, response);
				} else {
					request.setAttribute("error", "Something went wrong!");
					request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
				}
			}	

		} else {
			request.setAttribute("error", "The password isn't equal");
		}
	}

}
