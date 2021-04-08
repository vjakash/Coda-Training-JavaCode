package action;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbutility.UserDAOImpl;
import dbutility.UserDTO;

public class RegisterAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		UserDTO item=UserDTO.getUserDTO();
		
		item.setUserid(Integer.valueOf(String.valueOf(Math.random()).substring(2, 8)));
		item.setUsername(request.getParameter("username"));
		item.setPassword(request.getParameter("password"));
		item.setEmail(request.getParameter("email"));
		item.setDob(request.getParameter("dob"));
		item.setAge(Integer.valueOf(request.getParameter("age")));
		item.setPhone(request.getParameter("phone"));
		item.setFlag(0);
		
		UserDAOImpl userDAOImp=new UserDAOImpl();
		
		userDAOImp.insertUser(item);
		
		return "loginpage";
	}
}
