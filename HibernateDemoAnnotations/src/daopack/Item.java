package daopack;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "itemmaster1")
public class Item implements Serializable,Cloneable{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int itemid;
	private String item_name;
	private String item_unit;
	private float price;
	private String type;
	private String img_url;
	

	private static Item itemDTO;
	synchronized public static Item getItemDTO() {
		if(itemDTO==null) {
			itemDTO=new Item();
		}
		return itemDTO.getCloneItemDTO();		
	}
	
	private Item getCloneItemDTO() {
		try {
			return (Item)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	private Item() {
		// TODO Auto-generated constructor stub
	}
	
	

	

	@Override
	public String toString() {
		return "ItemDTO [itemid=" + itemid + ", item_name=" + item_name + ", item_unit=" + item_unit + ", price="
				+ price + ", type=" + type + ", img_url=" + img_url + "]";
	}

	public final int getItemid() {
		return itemid;
	}
	public final void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public final String getItem_name() {
		return item_name;
	}
	public final void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public final String getItem_unit() {
		return item_unit;
	}
	public final void setItem_unit(String item_unit) {
		this.item_unit = item_unit;
	}
	public final float getPrice() {
		return price;
	}
	public final void setPrice(float price) {
		this.price = price;
	}
	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
