package bookstore.servlets;

import java.io.IOException;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookstore.dao.UserDAO;
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
			
			newUser.setLogin(login);
			newUser.setPassword(password);
			
			UserDAO userDAO = (UserDAO)request.getAttribute("UserDAO");
			try {
				userDAO.getUser(login);
				request.setAttribute("error", "User already exist!");
				doGet(request, response);

			}catch(NoResultException e) {
				if (userDAO.addUser(newUser) ) {
					response.sendRedirect(request.getContextPath() + "/index");
				} else {
					request.setAttribute("error", "Something went wrong!");
					request.getRequestDispatcher("/WEB-INF/view/error.jsp").forward(request, response);
				}
			}
			

		}
	}

}
