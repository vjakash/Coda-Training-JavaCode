package com.customtags;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.Item;
import com.services.HomeService;

@Component
public class GetItem  extends TagSupport {
	
	List<Item> itemList;
	String type;
	String noOfItems;
	
	public String getNoOfItems() {
		return noOfItems;
	}

	public void setNoOfItems(String noOfItems) {
		this.noOfItems = noOfItems;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	private static HomeService homeService;

	
	@Override
	public int doStartTag() throws JspException {
		itemList=homeService.getAllItemsByType(type);
		JspWriter out=pageContext.getOut();
		HttpSession session=pageContext.getSession();
		Map<String, ArrayList<Float>> cart=(Map<String, ArrayList<Float>>)session.getAttribute("cart");
		if(cart==null) {
			cart=new HashMap<String, ArrayList<Float>>();
			session.setAttribute("cart", cart);
		}
		int len=!noOfItems.equals("*")?Integer.valueOf(noOfItems):itemList.size();
		try {
			out.println("<div class=\"productList\">\n");
			for(int i=0;i<len;i++) {
				float quantity=cart.get(itemList.get(i).getName())==null?0:cart.get(itemList.get(i).getName()).get(0);
				out.println( "<div class=\"product\">\n"
						+ "			<img src=\""+itemList.get(i).getImageUrl()+"\"/>\n"
						+ "			<p class=\"productName\">"+itemList.get(i).getName()+"</p>\n"
						+ "			<p class=\"productPrice\">₹ "+itemList.get(i).getPrice()+"/"+itemList.get(i).getUnit()+"</p>\n"
						+ "			<form onSubmit=\"return false;\">\n"
						+ "				<input id="+itemList.get(i).getItem_id()+" class=\"quantityInput\" type=\"number\" step=\"0.5\" value=\""+quantity+"\" min=\"0\"/>\n"
						+ "				<button class=\"addCartBtn\" value=\"Add to cart\" onClick=addItem(event,"+itemList.get(i).getItem_id()+",\""+itemList.get(i).getName()+"\","+itemList.get(i).getPrice()+")>Add to cart</button>\n"
						+ "			</form>\n"
						+ "		</div>\n");
			}
			if(!noOfItems.equals("*")) {
				out.println("<a href=\"category/"+type+"\">	<div class=\"productViewMore\">\n"
						+ "			<p>View More&nbsp; -&gt;</p>\n"
						+ "		</div>\n</a>");
			}
			out.println("</div>");
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return super.doStartTag();
	}
	
	public HomeService getHomeService() {
		return homeService;
	}
	@Autowired
	public void setHomeService(HomeService homeService) {
		GetItem.homeService = homeService;
	}
}
