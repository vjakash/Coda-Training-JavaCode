package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dbutility.UserDAOImpl;

public class LogoutAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		Integer userid=Integer.valueOf(session.getAttribute("userid").toString());
		
		UserDAOImpl userDAOImp=new UserDAOImpl();
		int i=userDAOImp.UpdateFlag(userid, 0);
		return "loginpage";
	}
}
