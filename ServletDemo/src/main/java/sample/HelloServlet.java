package sample;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
public class HelloServlet extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init method called...............");
		
		String s=config.getInitParameter("myparam");
		System.out.println("Param value of myparam is...:"+s);
		
		System.out.println(config.getInitParameter("dbconfig"));
		
		Enumeration<String> e=config.getInitParameterNames();
		while(e.hasMoreElements()) {
			String name=e.nextElement();
			String value=config.getInitParameter(name);
			System.out.println(name+":"+value);
		}
		
		System.out.println("Name of the servlet..:"+config.getServletName());
		
		ServletContext application=config.getServletContext();
		System.out.println(application.getRealPath(""));
		
		application.setAttribute("global", "global value...............");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do get method called");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("do post method called");
		doGet(request, response);
	}
	@Override
	public void destroy() {
		System.out.println("updated destroy method called");
	}
}
