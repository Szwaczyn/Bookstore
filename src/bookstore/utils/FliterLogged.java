package bookstore.utils;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookstore.dao.UserDAO;
import bookstore.entity.User;
//import jdk.internal.reflect.ReflectionFactory.GetReflectionFactoryAction;

@WebFilter("/*")
public class FliterLogged implements Filter {

    /**
     * Default constructor. 
     */
    public FliterLogged() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		req.setCharacterEncoding("UTF-8");
		String login = req.getRemoteUser();
		if(login != null) {
			User u = (User)req.getSession().getAttribute("User");
			if(u == null) {
				UserDAO userDAO = (UserDAO)req.getAttribute("UserDAO");
				u = userDAO.getUser(login);
				req.setAttribute("User", u);
			}
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
