package control;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daopack.UserDAOImpl;
import servicepack.LoginService;
import servicepack.LoginServiceImpl;

public class LoginAction extends Action{
	public LoginAction() {
		// TODO Auto-generated constructor stub
	}
@Override
public String execute(HttpServletRequest request, HttpServletResponse response) {
	String uname=request.getParameter("uname");
	String upass=request.getParameter("upass");
	
	LoginServiceImpl loginService=LoginServiceImpl.getLoginService();
	loginService.setUserDAO(UserDAOImpl.getUserDaoImpl((Properties)request.getServletContext().getAttribute("dbConfigProp")));
	HttpSession session=request.getSession();
	
	if(loginService.checkUser(uname, upass)) {
		if(loginService.checkFlag(uname)) {
			loginService.updateFlag(uname, 1);
			session.setAttribute("uname",uname);
			session.setAttribute("Uid", loginService.getUid(uname));
			return "login.success";
		}
		else {
			session.setAttribute("Uid", loginService.getUid(uname));
			return "login.already";
		}
		
		
	}
	else {
		return "login.register";
	}
}
}
