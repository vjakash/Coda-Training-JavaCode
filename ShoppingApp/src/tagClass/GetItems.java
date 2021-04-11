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
//		System.out.println((Properties)pageContext.getRequest().getServletContext().getAttribute("dbConfigProp"));
		Map<String,ArrayList<Float>> cart=(Map<String,ArrayList<Float>>)pageContext.getSession().getAttribute("cart");
		if(cart==null) {
			cart=new HashMap<String, ArrayList<Float>>();
		}
		ItemMasterDAOImpl itemMasterDAOImpl=ItemMasterDAOImpl.getItemMasterDaoImpl((Properties)pageContext.getRequest().getServletContext().getAttribute("dbConfigProp"));
		itemList=itemMasterDAOImpl.findAllByType(type);
//		System.out.println(itemList);
		JspWriter out=pageContext.getOut();
		for(int i=0;i<itemList.size();i++){
				try {
					out.print(itemList.get(i).getItem_name()+"<input type=\"checkbox\" name="+itemList.get(i).getItem_name()+" value="+itemList.get(i).getPrice()+" "+(cart.get(itemList.get(i).getItem_name())!=null?"checked":null)+"/>");
					out.println("<p>Price: "+itemList.get(i).getPrice()+"/"+itemList.get(i).getItem_unit()+"<br><br>");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return super.doStartTag();
	}
}
