package control;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daopack.UserDAOImpl;
import servicepack.LoginServiceImpl;

public class LogoutAction extends Action {
 @Override
public String execute(HttpServletRequest request, HttpServletResponse response) {
	HttpSession session=request.getSession();
	String uname=String.valueOf(session.getAttribute("uname"));
	
	LoginServiceImpl lservice=LoginServiceImpl.getLoginService();
	lservice.setUserDAO(UserDAOImpl.getUserDaoImpl((Properties)request.getServletContext().getAttribute("dbConfigProp")));
	lservice.updateFlag(uname, 0);
	
	return "logout.success";
}
}
