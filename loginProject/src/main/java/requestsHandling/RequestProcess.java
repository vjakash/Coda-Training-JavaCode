package requestsHandling;

import java.io.FileInputStream;

import java.lang.reflect.Constructor;

import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;

public class RequestProcess implements Cloneable {
	private static RequestProcess obj=null;
	
	public String process(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		Properties prop=new Properties();
		prop.load(new FileInputStream("/Users/vj/eclipse-workspace/loginProject/config.Properties"));
		String formid=prop.getProperty(request.getParameter("formid"));
		System.out.println(formid);

		Class actionClass = Class.forName(formid);
		Constructor constructor = actionClass.getConstructor();
		Action action = (Action)constructor.newInstance();
		
		String result=action.execute(request, response);
		
		response.sendRedirect(prop.getProperty(result));
		
		return result;
	}
	
	public static RequestProcess getRequestProcess() throws CloneNotSupportedException {
		if(obj==null) {
			obj=new RequestProcess();
		}
		return obj.getClone();
	}
	private  RequestProcess getClone() throws CloneNotSupportedException {
		return (RequestProcess)super.clone();
	}
	private RequestProcess() {
		
	}
}
