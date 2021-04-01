package day19;


import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

public class InvoiceTransactionDTO implements Serializable,Cloneable{
	private int invoiceid;
	private int itemid;
	private int quantity;
	
	private static InvoiceTransactionDTO InvoiceTransactionDTO;
	synchronized public static InvoiceTransactionDTO getInvoiceTransactionDTO() {
		if(InvoiceTransactionDTO==null) {
			InvoiceTransactionDTO=new InvoiceTransactionDTO();
		}
		return InvoiceTransactionDTO.getCloneInvoiceTransactionDTO();		
	}
	
	private InvoiceTransactionDTO getCloneInvoiceTransactionDTO() {
		try {
			return (InvoiceTransactionDTO)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	private InvoiceTransactionDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "ItemDTO [invoiceid=" + invoiceid + ", itemid=" + itemid + ", quantity=" + quantity + "]";
	}

	public int getInvoiceid() {
		return invoiceid;
	}

	public void setInvoiceid(int invoiceid) {
		this.invoiceid = invoiceid;
	}

	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	

	

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + customerid;
//		result = prime * result + ((item_unit == null) ? 0 : item_unit.hashCode());
//		result = prime * result + invoiceid;
//		result = prime * result + Float.floatToIntBits(price);
//		return result;
//	}
//
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		InvoiceTransactionDTO other = (InvoiceTransactionDTO) obj;
//		if (item_name == null) {
//			if (other.item_name != null)
//				return false;
//		} else if (!item_name.equals(other.item_name))
//			return false;
//		if (item_unit == null) {
//			if (other.item_unit != null)
//				return false;
//		} else if (!item_unit.equals(other.item_unit))
//			return false;
//		if (invoiceid != other.invoiceid)
//			return false;
//		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
//			return false;
//		return true;
//	}

}
