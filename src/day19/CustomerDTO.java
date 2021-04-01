package day19;


import java.io.Serializable;


public class CustomerDTO implements Serializable,Cloneable{
	private int customerid;
	private String customername;
	private String customeraddress;
	private String customercellphone;
	private int customergstnumber;
	
	private static CustomerDTO customerDTO;
	synchronized public static CustomerDTO getCustomerDTO() {
		if(customerDTO==null) {
			customerDTO=new CustomerDTO();
		}
		return customerDTO.getCloneCustomerDTO();		
	}
	
	private CustomerDTO getCloneCustomerDTO() {
		try {
			return (CustomerDTO)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	private CustomerDTO() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "CustomerDTO [customerid=" + customerid + ", customername=" + customername + ", customeraddress=" + customeraddress + ", customercellphone="+customercellphone+", customergstnumber="+customergstnumber+"]";
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getCustomeraddress() {
		return customeraddress;
	}

	public void setCustomeraddress(String customeraddress) {
		this.customeraddress = customeraddress;
	}

	public String getCustomercellphone() {
		return customercellphone;
	}

	public void setCustomercellphone(String customercellphone) {
		this.customercellphone = customercellphone;
	}

	public int getCustomergstnumber() {
		return customergstnumber;
	}

	public void setCustomergstnumber(int customergstnumber) {
		this.customergstnumber = customergstnumber;
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
//		CustomerDTO other = (CustomerDTO) obj;
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
