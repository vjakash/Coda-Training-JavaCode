package control;

import java.util.Properties;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import daopack.UserDAOImpl;
import servicepack.LoginServiceImpl;

/**
 * Application Lifecycle Listener implementation class MySessionListner
 *
 */
public class MySessionListner implements HttpSessionListener {


    public void sessionCreated(HttpSessionEvent se)  { 
         System.out.println("Session created...");
    }


    public void sessionDestroyed(HttpSessionEvent se)  { 
         System.out.println("Session destroyed..");
         HttpSession session=se.getSession();
         Object name=session.getAttribute("uname");
     	if(name!=null) {
     		String uname=name.toString();
     		LoginServiceImpl login=LoginServiceImpl.getLoginService();
     		login.setUserDAO(UserDAOImpl.getUserDaoImpl((Properties)session.getServletContext().getAttribute("dbConfigProp")));
     		login.updateFlag(uname, 0);
     	}
    }
	
}
