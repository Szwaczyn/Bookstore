package bookstore.servlets;

import java.io.IOException;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookstore.dao.BookDAO;
import bookstore.entity.Book;

/**
 * Servlet implementation class Book
 */
@WebServlet("/Book")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stringID = (String)request.getAttribute("id");
		if(!"".equals(stringID) && stringID != null) {
			int id = Integer.parseInt(stringID);
			BookDAO bookDAO = (BookDAO)request.getAttribute("BookDAO");
			
			try {
				Book book = bookDAO.getBook(id);
				request.setAttribute("book", book);
				request.getRequestDispatcher("/WEB-INF/view/book.jsp").forward(request, response);
			}catch(NoResultException e) {
				response.sendRedirect(request.getContextPath() + "/");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
