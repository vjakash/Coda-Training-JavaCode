package com.customtags;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
//		System.out.println(itemList);
		JspWriter out=pageContext.getOut();
		int len=!noOfItems.equals("*")?Integer.valueOf(noOfItems):itemList.size();
		try {
			out.println("<div class=\"productList\">\n");
			for(int i=0;i<len;i++) {
				out.println( "<div class=\"product\">\n"
						+ "			<img src=\""+itemList.get(i).getImageUrl()+"\"/>\n"
						+ "			<p class=\"productName\">"+itemList.get(i).getName()+"</p>\n"
						+ "			<p class=\"productPrice\">₹ "+itemList.get(i).getPrice()+"/"+itemList.get(i).getUnit()+"</p>\n"
						+ "			<form>\n"
						+ "				<input class=\"quantityInput\" type=\"number\" step=\"0.5\" value=\"0\" min=\"0\"/>\n"
						+ "				<input class=\"addCartBtn\" type=\"submit\" value=\"Add to cart\">\n"
						+ "			</form>\n"
						+ "		</div>\n");
			}
			out.println("	<div class=\"productViewMore\">\n"
					+ "			<p>View More&nbsp; -&gt;</p>\n"
					+ "		</div>\n"
					+ "	</div>");
	
		} catch (Exception e) {
			// TODO: handle exception
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
