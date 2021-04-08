package dbutility;


import java.io.Serializable;


public class UserDTO implements Serializable,Cloneable{
	private int userid;
	private String username;
	private String password;
	private String email;
	private String dob;
	private int age;
	private String phone;
	private int flag;
	
	private static UserDTO userDTO;
	synchronized public static UserDTO getUserDTO() {
		if(userDTO==null) {
			userDTO=new UserDTO();
		}
		return userDTO.getCloneUserDTO();		
	}
	
	private UserDTO getCloneUserDTO() {
		try {
			return (UserDTO)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	private UserDTO() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "UserDTO [userid=" + userid + ", username=" + username + ", password=" + password + ", email=" + email
				+ ", dob=" + dob + ", age=" + age + ", phone=" + phone + ", flag=" + flag + "]";
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
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
//		UserDTO other = (UserDTO) obj;
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
