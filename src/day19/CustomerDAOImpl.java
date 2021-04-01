package day19;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import day18.DBUtility;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public CustomerDTO findByID(Integer customerid) throws SQLException {
		CustomerDTO item=null;
		Connection con=DBUtility.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("SELECT * FROM customers WHERE customerid=?");
			ps.setInt(1, customerid);
			ResultSet rs=ps.executeQuery();
			
//			ResultSetMetaData rsmd=rs.getMetaData();
//			int colCount=rsmd.getColumnCount();
			
			while(rs.next()) {
				item=CustomerDTO.getCustomerDTO();
				item.setCustomerid(rs.getInt(1));
				item.setCustomername(rs.getString(2));
				item.setCustomeraddress(rs.getString(3));
				item.setCustomercellphone(rs.getString(4));
				item.setCustomergstnumber(rs.getInt(5));
			}
			DBUtility.closeConnection(null, null);
			return item;
		}catch(Exception e) {
			DBUtility.closeConnection(e, null);
			return item;
		}	
	}

	@Override
	public List<CustomerDTO> findAll() {
		List<CustomerDTO> itemList=null;
		Connection con=DBUtility.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("SELECT * FROM customers;");
			ResultSet rs=ps.executeQuery();
			
//			ResultSetMetaData rsmd=rs.getMetaData();

			while(rs.next()) {
				itemList=new ArrayList<CustomerDTO>();
				CustomerDTO item=CustomerDTO.getCustomerDTO();
				item.setCustomerid(rs.getInt(1));
				item.setCustomername(rs.getString(2));
				item.setCustomeraddress(rs.getString(3));
				item.setCustomercellphone(rs.getString(4));
				item.setCustomergstnumber(rs.getInt(5));
				itemList.add(item);
			}
			DBUtility.closeConnection(null, null);
			return itemList;
		}catch(Exception e) {
			DBUtility.closeConnection(e, null);
			return itemList;
		}	
	}

	@Override
	public int insertCustomer(CustomerDTO customerDTO) {
		Connection con=DBUtility.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("INSERT INTO customers VALUES(?,?,?,?,?)");
			ps.setInt(1,customerDTO.getCustomerid());
			ps.setString(2, customerDTO.getCustomername());
			ps.setString(3, customerDTO.getCustomeraddress());
			ps.setString(4, customerDTO.getCustomercellphone());
			ps.setInt(5, customerDTO.getCustomergstnumber());
			int i=ps.executeUpdate();
			DBUtility.closeConnection(null, null);
			return i;
			
		}catch(Exception e){
			DBUtility.closeConnection(e, null);
			return 0;
		}
	}

	@Override
	public int updateCustomer(CustomerDTO customerDTO) {
		Connection con=DBUtility.getConnection();
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("UPDATE customers SET customername=?,customeraddress=?,customercellphone=?,customergstnumber=? WHERE customerid=?;");
			ps.setString(1, customerDTO.getCustomername());
			ps.setString(2, customerDTO.getCustomeraddress());
			ps.setString(3, customerDTO.getCustomercellphone());
			ps.setInt(4, customerDTO.getCustomergstnumber());
			ps.setInt(5, customerDTO.getCustomerid());
			i=ps.executeUpdate();
			DBUtility.closeConnection(null, null);
			return i;
			
		}catch(Exception e){
			DBUtility.closeConnection(e, null);
			return i;
		}
	}

	@Override
	public int deleteCustomerByID(Integer customerid) {
		Connection con=DBUtility.getConnection();
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("DELETE FROM customers WHERE customerid=?;");
			ps.setInt(1,customerid);
			i=ps.executeUpdate();
			DBUtility.closeConnection(null, null);
			return i;
		}catch(Exception e){
			DBUtility.closeConnection(e, null);
			return i;
		}
	}

	@Override
	public int deleteCustomerByDTO(CustomerDTO customerDTO) {
		Connection con=DBUtility.getConnection();
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("DELETE FROM customers WHERE customerid=?;");
			ps.setInt(1,customerDTO.getCustomerid());
			i=ps.executeUpdate();
			DBUtility.closeConnection(null, null);
			return i;
		}catch(Exception e){
			DBUtility.closeConnection(e, null);
			return i;
		}
	}
//	public static void main(String[] args) throws Exception{
//		
//		CustomerDAOImpl imp=new CustomerDAOImpl();
//		
//		CustomerDTO customer=CustomerDTO.getCustomerDTO();
//		customer.setCustomerid(1001);
//		customer.setCustomername("vj");
//		customer.setCustomeraddress("abc,xyq,chennai");
//		customer.setCustomercellphone("8870630987");
//		customer.setCustomergstnumber(234567);
//		
//		imp.insertCustomer(customer);
//		List<CustomerDTO> result=imp.findAll();
//		System.out.println(result);
//	}

}
