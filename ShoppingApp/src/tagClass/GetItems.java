package tagClass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

import daopack.ItemDTO;
import daopack.ItemMasterDAOImpl;

public class GetItems extends TagSupport {
	List<ItemDTO> itemList;
	String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<ItemDTO> getItemList() {
		return itemList;
	}

	public void setItemList(List<ItemDTO> itemList) {
		this.itemList = itemList;
	}

	@Override
	public int doStartTag() throws JspException {
		Map<String,ArrayList<Float>> cart=(Map<String,ArrayList<Float>>)pageContext.getSession().getAttribute("cart");
		if(cart==null) {
			cart=new HashMap<String, ArrayList<Float>>();
		}
		ItemMasterDAOImpl itemMasterDAOImpl=ItemMasterDAOImpl.getItemMasterDaoImpl((Properties)pageContext.getRequest().getServletContext().getAttribute("dbConfigProp"));
		itemList=itemMasterDAOImpl.findAllByType(type);
//		System.out.println(itemList);
		JspWriter out=pageContext.getOut();
		try {
			out.println("<div class=\"itemContainer\">");
			for(int i=0;i<itemList.size();i++){
				out.println("<div class=\"item\">");
				out.println("<img  src=\""+itemList.get(i).getImg_url()+"\" width=150 height=150>");
				out.println("<p>&nbsp;"+"<input type=\"checkbox\" name="+itemList.get(i).getItem_name()+" value="+itemList.get(i).getPrice()+" "+(cart.get(itemList.get(i).getItem_name())!=null?"checked":null)+"/>"+"&nbsp; "+itemList.get(i).getItem_name()+" </p>");
//				out.print(itemList.get(i).getItem_name()+"<input type=\"checkbox\" name="+itemList.get(i).getItem_name()+" value="+itemList.get(i).getPrice()+" "+(cart.get(itemList.get(i).getItem_name())!=null?"checked":null)+"/>");
				out.println("<p style=\"padding-left:10px;\">Price: Rs."+itemList.get(i).getPrice()+"/"+itemList.get(i).getItem_unit()+"</p>");
//				out.println("<p>Price: "+itemList.get(i).getPrice()+"/"+itemList.get(i).getItem_unit()+"<br><br>");
				out.println("</div>");

			}
			out.println("</div>");
		} catch (Exception e) {
			// TODO: handle exception
		}
		
   		
   			
 

		return super.doStartTag();
	}
}
