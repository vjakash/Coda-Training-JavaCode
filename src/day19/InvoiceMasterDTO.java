package day19;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

public class InvoiceMasterDTO implements Serializable,Cloneable{
	private int invoiceid;
	private int customerid;
	private String invoicedate;
	
	private static InvoiceMasterDTO invoiceMasterDTO;
	synchronized public static InvoiceMasterDTO getInvoiceMasterDTO() {
		if(invoiceMasterDTO==null) {
			invoiceMasterDTO=new InvoiceMasterDTO();
		}
		return invoiceMasterDTO.getCloneInvoiceMasterDTO();		
	}
	
	private InvoiceMasterDTO getCloneInvoiceMasterDTO() {
		try {
			return (InvoiceMasterDTO)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	private InvoiceMasterDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "ItemDTO [invoiceid=" + invoiceid + ", customerid=" + customerid + ", invoicedate=" + invoicedate + "]";
	}

	

	public int getInvoiceid() {
		return invoiceid;
	}

	public void setInvoiceid(int invoiceid) {
		this.invoiceid = invoiceid;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getInvoicedate() {
		return invoicedate;
	}

	public void setInvoicedate(String date) {
		this.invoicedate = date;
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
//		InvoiceMasterDTO other = (InvoiceMasterDTO) obj;
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
