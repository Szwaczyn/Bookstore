package bookstore.servlets;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookstore.dao.BookDAO;
import bookstore.entity.Book;

/**
 * Servlet implementation class NewBook
 */
@WebServlet("/newbook")
public class NewBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/view/newbook.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String author = request.getParameter("author");
		String title = request.getParameter("title");
		String releasedDate = request.getParameter("realesed");
		
		if(!"".equals(author) && !"".equals(title) && !"".equals(releasedDate)) {
			Book newBook = new Book();
			newBook.setAuthor(author);
			newBook.setName(title);
			Timestamp released = Timestamp.valueOf(releasedDate);
			newBook.setReleased(released);
			
			BookDAO bookDAO = (BookDAO)request.getAttribute("BookDAO");
			
			if (bookDAO.addBook(newBook)) {
				response.sendRedirect(request.getContextPath() + "/book?id=" + newBook.getId());
			}
		}
	}

}
