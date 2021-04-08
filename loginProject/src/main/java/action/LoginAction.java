package action;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import dbutility.UserDAOImpl;
import dbutility.UserDTO;

public class LoginAction extends Action{

	public String execute(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws IOException {
		UserDAOImpl userDAOImp=new UserDAOImpl();
		UserDTO result=userDAOImp.findByUsername(request.getParameter("username"));
		if(result!=null) {//if user present
			if(result.getFlag()==1) {//if user already logged in
				return "login.already";
			}else if(result.getPassword().equals(request.getParameter("password"))) {//if your is not loggedin and password is correct
				 userDAOImp.UpdateFlag(result.getUserid(), 1);
				 HttpSession session=request.getSession();
				 session.setAttribute("userid",String.valueOf(result.getUserid()));
				 return "login.success";
			}else {//not logged in and password incorrect
			    return "loginpage"; 
			}
		}else {//user not present
			return "login.register";
		}		
	};
}
