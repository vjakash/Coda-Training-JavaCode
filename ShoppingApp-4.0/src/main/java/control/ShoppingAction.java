package control;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daopack.ItemDTO;

public class ShoppingAction extends Action{
@Override
public String execute(HttpServletRequest request, HttpServletResponse response) {
	String shopid=request.getParameter("shopid");
	
	Enumeration<String> e=request.getParameterNames();
	
	HttpSession session=request.getSession();
	Map<String, ArrayList<Float>> cart=(Map<String, ArrayList<Float>>) session.getAttribute("cart");
	if(cart==null) {
		cart=new HashMap<String, ArrayList<Float>>();
	}
	while(e.hasMoreElements()) {
		String name=e.nextElement();
		String value=request.getParameter(name);
		System.out.println(name+" "+value);
		if(name.equals("formid")||name.equals("shopid")) {
			
		}
		else {
			ArrayList<Float> values=new ArrayList<Float>();
			values.add(1f);
			values.add(Float.parseFloat(value));
			cart.put(name, values);
		}
	}
//	System.out.println(cart);
	session.setAttribute("cart",cart);
	return shopid;
}
}
