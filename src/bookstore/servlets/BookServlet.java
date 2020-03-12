package bookstore.servlets;

import java.io.IOException;

import javax.persistence.NoResultException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.coyote.Request;

import bookstore.dao.BookDAO;
import bookstore.dao.CommentDAO;
import bookstore.entity.Book;
import bookstore.entity.Comment;
import bookstore.entity.User;

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
		String messageContent = request.getParameter("messageContent");
		String bookID = request.getParameter("bookID");
		
		if(bookID != null && messageContent != null) {
			CommentDAO commentDAO =(CommentDAO) request.getAttribute("CommentDAO");
			BookDAO bookDAO = (BookDAO)request.getAttribute("BookDAO");
			int id = Integer.parseInt(bookID);
			User user = (User)request.getSession().getAttribute("user"); // Get current user
			Book book = bookDAO.getBook(id);
			
			Comment comment = new Comment();
			comment.setAuthor(user.getLogin());
			comment.setBook(book);
			comment.setContent(messageContent);
			
			commentDAO.addComment(comment);
		}
		
		doGet(request, response);
	}

}
