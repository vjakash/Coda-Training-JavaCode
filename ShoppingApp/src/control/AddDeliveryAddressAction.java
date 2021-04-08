package control;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddDeliveryAddressAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		Map<String,String> deliveryAddress=new HashMap<String, String>();
		deliveryAddress.put("name", request.getParameter("name"));
		deliveryAddress.put("doorno", request.getParameter("doorno"));
		deliveryAddress.put("street", request.getParameter("street"));
		deliveryAddress.put("area", request.getParameter("area"));
		deliveryAddress.put("city", request.getParameter("city"));
		deliveryAddress.put("pincode", request.getParameter("pincode"));
		HttpSession session=request.getSession();
		session.setAttribute("deliveryAddress", deliveryAddress);
		session.setAttribute("email", request.getParameter("email"));
		return "deliveryAddress.added";
	}
}
