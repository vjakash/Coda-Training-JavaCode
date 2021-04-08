package userlogin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbutility.DBUtility;
import dbutility.UserDAOImpl;
import dbutility.UserDTO;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("username:"+request.getParameter("username")+" password:"+request.getParameter("password"));
		UserDAOImpl userDAOImp=new UserDAOImpl();
		UserDTO result=userDAOImp.findByUsername(request.getParameter("username"));
		if(result!=null) {
			if(result.getPassword().equals(request.getParameter("password")) && result.getFlag()==0) {
				 int i=userDAOImp.UpdateFlag(result.getUserid(), 1);
				 HttpSession session=request.getSession();
				 session.setAttribute("userid",String.valueOf(result.getUserid()));
				 response.sendRedirect("welcome.html");
			}else {
				response.sendRedirect("register.html");
			}
		}
		
	}

}
