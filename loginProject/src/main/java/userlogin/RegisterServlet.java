package userlogin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbutility.DBUtility;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("date:"+request.getParameter("dob"));
		Integer.valueOf(String.valueOf(Math.random()).substring(2, 8));
		Connection con=DBUtility.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("INSERT INTO userdata VALUES(?,?,?,?,?,?,?,?)");
			ps.setInt(1,Integer.valueOf(String.valueOf(Math.random()).substring(2, 8)));
			ps.setString(2, request.getParameter("username"));
			ps.setString(3, request.getParameter("password"));
			ps.setString(4, request.getParameter("email"));
			ps.setString(5, request.getParameter("dob"));
			ps.setInt(6,Integer.valueOf(request.getParameter("age")));
			ps.setString(7, request.getParameter("phone"));
			ps.setInt(8, 0);
			int i=ps.executeUpdate();
			response.sendRedirect("index.html");
			DBUtility.closeConnection(null, null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			DBUtility.closeConnection(e, null);
			e.printStackTrace();
		}
	}

}
