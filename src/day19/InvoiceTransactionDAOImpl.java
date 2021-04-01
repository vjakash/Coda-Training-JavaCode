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

public class InvoiceTransactionDAOImpl implements InvoiceTransactionDAO {

	@Override
	public InvoiceTransactionDTO findByID(Integer invoiceid) throws SQLException {
		InvoiceTransactionDTO item=null;
		Connection con=DBUtility.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("SELECT * FROM invoicetransaction WHERE invoiceid=?");
			ps.setInt(1, invoiceid);
			ResultSet rs=ps.executeQuery();
			
			ResultSetMetaData rsmd=rs.getMetaData();
//			int colCount=rsmd.getColumnCount();
			
			while(rs.next()) {
				item=InvoiceTransactionDTO.getInvoiceTransactionDTO();
				item.setInvoiceid(rs.getInt(1));
				item.setItemid(rs.getInt(2));
				item.setQuantity(rs.getInt(3));
			}
			DBUtility.closeConnection(null, null);
			return item;
		}catch(Exception e) {
			DBUtility.closeConnection(e, null);
			return item;
		}	
	}

	@Override
	public List<InvoiceTransactionDTO> findAll() {
		List<InvoiceTransactionDTO> itemList=null;
		Connection con=DBUtility.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("SELECT * FROM invoicetransaction;");
			ResultSet rs=ps.executeQuery();
			
			ResultSetMetaData rsmd=rs.getMetaData();
			while(rs.next()) {
				itemList=new ArrayList<InvoiceTransactionDTO>();
				InvoiceTransactionDTO item=InvoiceTransactionDTO.getInvoiceTransactionDTO();
				item.setInvoiceid(rs.getInt(1));
				item.setItemid(rs.getInt(2));
				item.setQuantity(rs.getInt(3));
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
	public int insertInvoiceTransaction(InvoiceTransactionDTO invoiceTransactionDTO) {
		Connection con=DBUtility.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("INSERT INTO invoicetransaction VALUES(?,?,?)");
			ps.setInt(1,invoiceTransactionDTO.getInvoiceid());
			ps.setInt(2, invoiceTransactionDTO.getItemid());
			ps.setInt(3, invoiceTransactionDTO.getQuantity());
			int i=ps.executeUpdate();
			DBUtility.closeConnection(null, null);
			return i;
			
		}catch(Exception e){
			DBUtility.closeConnection(e, null);
			return 0;
		}
	}

	@Override
	public int updateInvoiceTransaction(InvoiceTransactionDTO invoiceTransactionDTO) {
		Connection con=DBUtility.getConnection();
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("UPDATE invoicetransaction SET itemid=?,quantity=? WHERE invoiceid=?;");
			ps.setInt(1, invoiceTransactionDTO.getItemid());
			ps.setInt(2, invoiceTransactionDTO.getQuantity());
			ps.setInt(3, invoiceTransactionDTO.getInvoiceid());
			i=ps.executeUpdate();
			DBUtility.closeConnection(null, null);
			return i;
			
		}catch(Exception e){
			DBUtility.closeConnection(e, null);
			return i;
		}
	}

	@Override
	public int deleteInvoiceTransactionByID(Integer invoiceid) {
		Connection con=DBUtility.getConnection();
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("DELETE FROM invoicetransaction WHERE invoiceid=?;");
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
	public int deleteInvoiceTransactionByDTO(InvoiceTransactionDTO invoiceTransactionDTO) {
		Connection con=DBUtility.getConnection();
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("DELETE FROM invoicetransaction WHERE invoiceid=?;");
			ps.setInt(1,invoiceTransactionDTO.getInvoiceid());
			i=ps.executeUpdate();
			DBUtility.closeConnection(null, null);
			return i;
		}catch(Exception e){
			DBUtility.closeConnection(e, null);
			return i;
		}
	}
//	public static void main(String[] args) throws Exception{
//		InvoiceTransactionDAOImpl imimpl=new InvoiceTransactionDAOImpl();
//		
//		InvoiceTransactionDTO invoice1=InvoiceTransactionDTO.getInvoiceTransactionDTO();
//		invoice1.setInvoiceid(100);
//		invoice1.setItemid(002);
//		invoice1.setQuantity(5);
//		
//		imimpl.insertInvoiceTransaction(invoice1);
//		List<InvoiceTransactionDTO> result=imimpl.findAll();
//		System.out.println(result);
//		
//		invoice1.setQuantity(5);
//	    imimpl.updateInvoiceTransaction(invoice1);
//	    
//	   System.out.println( imimpl.findByID(101));
//	   
//	   result=imimpl.findAll();
//	   System.out.println(result);
//	   
//	   imimpl.deleteInvoiceTransactionByID(101);
//	   result=imimpl.findAll();
//	   System.out.println(result);
//	   
//	   imimpl.deleteInvoiceTransactionByDTO(invoice1);
//	   result=imimpl.findAll();
//	   System.out.println(result);
//		
//	}

}
