package com.customtags;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value= {"classpath:application.properties"})
public class GetCartItems extends TagSupport {

	
	private static Environment environment;
	
	public Environment getEnvironment() {
		return environment;
	}

	@Autowired
	public void setEnvironment(Environment environment) {
		GetCartItems.environment = environment;
	}

	@Override
	public int doStartTag() throws JspException {
		JspWriter out=pageContext.getOut();
		HttpSession session=pageContext.getSession();
		Map<String, ArrayList<Float>> cart=(Map<String, ArrayList<Float>>)session.getAttribute("cart");
		Float discount=Float.valueOf(environment.getRequiredProperty("cart.discount"));
		Float tax=Float.valueOf(environment.getRequiredProperty("cart.tax"));
		try {
			if(cart==null || cart.entrySet().size()==0) {
				cart=new HashMap<String, ArrayList<Float>>();
				session.setAttribute("cart", cart);
				out.println("<div class=\"alert\">\n"
						+ "	            <p>Cart is empty</p>\n"
						+ "	            <p>Please add item in the cart</p>\n"
						+ "	        </div>");
			}else {
				out.println(" <div class=\"mainCart\" >");
				Float total=0f;
				for(Map.Entry<String, ArrayList<Float>> item:cart.entrySet()) {
					String itemName=item.getKey();
					Float quantity=item.getValue().get(0);
					Float price=item.getValue().get(1);
					total+=(price*quantity);
					out.println("<div class=\"cartItem\">\n"
							+ "	                    <p class=\"cartItemName\"> <button class=\"delete\" ><i class=\"fa fa-times\"></i></button><span>"+itemName+"</span></p>\n"
							+ "	                    <p> <span class=\"headingToHide\">Rate- </span> "+price+"/kg</p>\n"
							+ "	                    <input type=\"number\" class=\"product-quantity-box\" value=\""+quantity+"\">\n"
							+ "	                        \n"
							+ "	                    <!-- </div> -->\n"
							+ "	                    <p><span class=\"headingToHide\">Price- </span> "+(price*quantity)+"</p>\n"
							+ "	                </div>");
				}
				Float discountedPrice=total*(discount/100);
				Float taxPrice=total*(tax/100);
				Float grandTotal=total-discountedPrice+taxPrice;
				out.println("</div>");
				out.println("<div class=\"totalPrice\" style=\"margin-top:10px;\">\n"
						+ "	            <p></p>\n"
						+ "	            <p> Total:</p>\n"
						+ "	            <p>"+total+"</p>\n"
						+ "	        </div>\n"
						+ "	       <div class=\"totalPrice\">\n"
						+ "	            <p></p>\n"
						+ "	            <p style=\"color:green\" class=\"discountedPrice\">Tax:</p>\n"
						+ "	            <p style=\"color:green\" class=\"discountedPrice\">+"+taxPrice+"</p>\n"
						+ "	        </div>\n"
						+ "	        <div class=\"totalPrice\">\n"
						+ "	            <p></p>\n"
						+ "	            <p class=\"discountedPrice\"> Discount:</p>\n"
						+ "	            <p class=\"discountedPrice\">-"+discountedPrice+"</p>\n"
						+ "	        </div>\n"
						+ "\n"
						+ "	        <div class=\"totalPrice grandTotal\">\n"
						+ "	            <p></p>\n"
						+ "	            <p>Grand Total</p>\n"
						+ "	            <p>"+grandTotal+"</p>\n"
						+ "	        </div>\n"
						+ "        	<a href=\"/deliveryAddress\"><button class=\"continueBtn\" >Continue</button></a>");
				session.setAttribute("grandTotal", grandTotal);
			}
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return super.doStartTag();
	}
}
