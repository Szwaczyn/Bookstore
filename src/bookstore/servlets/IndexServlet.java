package bookstore.servlets;

import java.io.IOException;
import java.util.List;
import bookstore.entity.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookstore.dao.BookDAO;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/Index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookDAO bookDAO = (BookDAO)request.getAttribute("BookDAO");
		List<Book> bookList = bookDAO.getBook();
		
		request.setAttribute("bookList", bookList);
		request.getRequestDispatcher("/WEV-INF/view/index.jsp").forward(request, response);;
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
