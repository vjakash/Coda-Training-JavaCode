package control;

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
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class MySessionFilter
 */
@WebFilter("*.do")
public class MySessionFilter implements Filter {
	public void destroy() {
		System.out.println("destroy filter called...");
	}
	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hrequest=(HttpServletRequest)request;
		HttpServletResponse hresponse=(HttpServletResponse)response;
		
		HttpSession session=hrequest.getSession();
		if(session.isNew()) {
			String formid=request.getParameter("formid");
			System.out.println(request.getParameter("formid"));
			if(formid.equals("lang")) {
				chain.doFilter(request, response);
			}
			else {
				hresponse.sendRedirect("sessionexpiry.jsp");
			}
		}
		else {
			chain.doFilter(request, response);	
		}
	}
	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("init filter called...");
	}
}
