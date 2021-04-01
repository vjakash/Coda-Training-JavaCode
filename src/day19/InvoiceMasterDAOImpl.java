package day19;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import day18.DBUtility;

public class InvoiceMasterDAOImpl implements InvoiceMasterDAO {

	@Override
	public InvoiceMasterDTO findByID(Integer invoiceid) throws SQLException {
		InvoiceMasterDTO item=null;
		Connection con=DBUtility.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("SELECT * FROM invoicemaster WHERE invoiceid=?");
			ps.setInt(1, invoiceid);
			ResultSet rs=ps.executeQuery();
			
//			ResultSetMetaData rsmd=rs.getMetaData();
//			int colCount=rsmd.getColumnCount();
			
			while(rs.next()) {
				item=InvoiceMasterDTO.getInvoiceMasterDTO();
				item.setInvoiceid(rs.getInt(1));
				item.setInvoicedate(rs.getString(2));
				item.setCustomerid(rs.getInt(3));
			}
			DBUtility.closeConnection(null, null);
			return item;
		}catch(Exception e) {
			DBUtility.closeConnection(e, null);
			return item;
		}	
	}

	@Override
	public List<InvoiceMasterDTO> findAll() {
		List<InvoiceMasterDTO> itemList=null;
		Connection con=DBUtility.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("SELECT * FROM invoicemaster;");
			ResultSet rs=ps.executeQuery();
			
//			ResultSetMetaData rsmd=rs.getMetaData();

			while(rs.next()) {
				itemList=new ArrayList<InvoiceMasterDTO>();
				InvoiceMasterDTO item=InvoiceMasterDTO.getInvoiceMasterDTO();
				item.setInvoiceid(rs.getInt(1));
				item.setInvoicedate(rs.getString(2));
				item.setCustomerid(rs.getInt(3));
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
	public int insertItem(InvoiceMasterDTO InvoiceMasterDTO) {
		Connection con=DBUtility.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("INSERT INTO invoicemaster VALUES(?,?,?)");
			ps.setInt(1,InvoiceMasterDTO.getInvoiceid());
			ps.setString(2, InvoiceMasterDTO.getInvoicedate());
			ps.setInt(3, InvoiceMasterDTO.getCustomerid());
			int i=ps.executeUpdate();
			DBUtility.closeConnection(null, null);
			return i;
			
		}catch(Exception e){
			DBUtility.closeConnection(e, null);
			return 0;
		}
	}

	@Override
	public int updateItem(InvoiceMasterDTO InvoiceMasterDTO) {
		Connection con=DBUtility.getConnection();
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("UPDATE invoicemaster SET invoicedate=?,customerid=? WHERE invoiceid=?;");
			ps.setString(1, InvoiceMasterDTO.getInvoicedate());
			ps.setInt(2, InvoiceMasterDTO.getCustomerid());
			ps.setInt(3, InvoiceMasterDTO.getInvoiceid());
			i=ps.executeUpdate();
			DBUtility.closeConnection(null, null);
			return i;
			
		}catch(Exception e){
			DBUtility.closeConnection(e, null);
			return i;
		}
	}

	@Override
	public int deleteItemByID(Integer invoiceid) {
		Connection con=DBUtility.getConnection();
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("DELETE FROM invoicemaster WHERE invoiceid=?;");
			ps.setInt(1,invoiceid);
			i=ps.executeUpdate();
			DBUtility.closeConnection(null, null);
			return i;
		}catch(Exception e){
			DBUtility.closeConnection(e, null);
			return i;
		}
	}

	@Override
	public int deleteItemByDTO(InvoiceMasterDTO InvoiceMasterDTO) {
		Connection con=DBUtility.getConnection();
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("DELETE FROM invoicemaster WHERE invoiceid=?;");
			ps.setInt(1,InvoiceMasterDTO.getInvoiceid());
			i=ps.executeUpdate();
			DBUtility.closeConnection(null, null);
			return i;
		}catch(Exception e){
			DBUtility.closeConnection(e, null);
			return i;
		}
	}
//	public static void main(String[] args) throws Exception{
//		InvoiceMasterDAOImpl imimpl=new InvoiceMasterDAOImpl();
//		
//		InvoiceMasterDTO invoice1=InvoiceMasterDTO.getInvoiceMasterDTO();
//		invoice1.setInvoiceid(101);
//		invoice1.setInvoicedate(LocalDateTime.now().toString());
//		invoice1.setCustomerid(201);
//		
//		imimpl.insertItem(invoice1);
//		List<InvoiceMasterDTO> result=imimpl.findAll();
//		System.out.println(result);
//		
//		invoice1.setInvoicedate(LocalDateTime.now().plus(1,ChronoUnit.DAYS).toString());
//	    imimpl.updateItem(invoice1);
//	    
//	   System.out.println( imimpl.findByID(101));
//	   
//	   result=imimpl.findAll();
//	   System.out.println(result);
//	   
//	   imimpl.deleteItemByID(100);
//	   result=imimpl.findAll();
//	   System.out.println(result);
//	   
//	   imimpl.deleteItemByDTO(invoice1);
//	   result=imimpl.findAll();
//	   System.out.println(result);
//		
//	}

}
