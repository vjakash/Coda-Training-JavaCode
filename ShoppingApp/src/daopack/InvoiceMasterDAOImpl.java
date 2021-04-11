package daopack;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.function.Function;

import org.apache.tomcat.util.http.fileupload.IOUtils;


public class InvoiceMasterDAOImpl implements InvoiceMasterDAO,Cloneable {
static private Properties  dbConfigProp;
	
	private static InvoiceMasterDAOImpl invoiceMasterDAOImpl;
	
	public static InvoiceMasterDAOImpl getItemMasterDaoImpl(Properties dbConProp) {
		dbConfigProp=dbConProp;
		if(invoiceMasterDAOImpl==null) {
			invoiceMasterDAOImpl=new InvoiceMasterDAOImpl();
		}
		return invoiceMasterDAOImpl.getClone();
	}
	
	public InvoiceMasterDAOImpl getClone() {
		try {
			return (InvoiceMasterDAOImpl)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	private InvoiceMasterDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public InvoiceMasterDTO findByID(String invoiceid)  {
		InvoiceMasterDTO item=null;
		Connection con=DBUtility1.getConnection(dbConfigProp);
		try {
			PreparedStatement ps=con.prepareStatement("SELECT * FROM invoiceblob WHERE invoiceid=?");
			ps.setString(1, invoiceid);
			ResultSet rs=ps.executeQuery();
			
//			ResultSetMetaData rsmd=rs.getMetaData();
//			int colCount=rsmd.getColumnCount();
			
			while(rs.next()) {
				item=InvoiceMasterDTO.getInvoiceMasterDTO();
				item.setInvoiceid(rs.getString(1));
				item.setUid(rs.getInt(2));
				item.setInvoicedate(rs.getString(3));
				item.setInvoicePDF(blobToByteArrayInputStream(rs.getBlob(4)));
				item.setInvoiceExcel(blobToByteArrayInputStream(rs.getBlob(5)));
			}
			DBUtility1.closeConnection(null, null);
			return item;
		}catch(Exception e) {
			DBUtility1.closeConnection(e, null);
			return item;
		}	
	}
	public ByteArrayInputStream blobToByteArrayInputStream(Blob blob) {
		ByteArrayInputStream bis=null;
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			IOUtils.copy(blob.getBinaryStream(), bos);
			bos.flush();
			bis=new ByteArrayInputStream(bos.toByteArray());
			return bis;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return bis;
		} 

	}
	@Override
	public List<InvoiceMasterDTO> findAll() {
		List<InvoiceMasterDTO> itemList=null;
		Connection con=DBUtility1.getConnection(dbConfigProp);
		try {
			PreparedStatement ps=con.prepareStatement("SELECT * FROM invoiceblob;");
			ResultSet rs=ps.executeQuery();
			
//			ResultSetMetaData rsmd=rs.getMetaData();

			while(rs.next()) {
				itemList=new ArrayList<InvoiceMasterDTO>();
				InvoiceMasterDTO item=InvoiceMasterDTO.getInvoiceMasterDTO();
				item.setInvoiceid(rs.getString(1));
				item.setUid(rs.getInt(2));
				item.setInvoicedate(rs.getString(3));
				item.setInvoicePDF(blobToByteArrayInputStream(rs.getBlob(4)));
				item.setInvoiceExcel(blobToByteArrayInputStream(rs.getBlob(5)));
				itemList.add(item);
			}
			DBUtility1.closeConnection(null, null);
			return itemList;
		}catch(Exception e) {
			DBUtility1.closeConnection(e, null);
			return itemList;
		}	
	}

	@Override
	public int insertItem(InvoiceMasterDTO InvoiceMasterDTO) {
		Connection con=DBUtility1.getConnection(dbConfigProp);
		try {
			PreparedStatement ps=con.prepareStatement("INSERT INTO invoiceblob VALUES(?,?,?,?,?)");
			ps.setString(1,InvoiceMasterDTO.getInvoiceid());
			ps.setInt(2, InvoiceMasterDTO.getUid());
			ps.setString(3, InvoiceMasterDTO.getInvoicedate());
			ps.setBlob(4, InvoiceMasterDTO.getInvoicePDF());
			ps.setBlob(5, InvoiceMasterDTO.getInvoiceExcel());
			int i=ps.executeUpdate();
			DBUtility1.closeConnection(null, null);
			return i;
			
		}catch(Exception e){
			DBUtility1.closeConnection(e, null);
			return 0;
		}
	}

	@Override
	public int updateItem(InvoiceMasterDTO InvoiceMasterDTO) {
		Connection con=DBUtility1.getConnection(dbConfigProp);
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("UPDATE invoiceblob SET invoicedate=?,uid=?,invoicePDF=?,invoiceExcel=? WHERE invoiceid=?;");
			ps.setString(1, InvoiceMasterDTO.getInvoicedate());
			ps.setInt(2, InvoiceMasterDTO.getUid());
			ps.setBlob(3, InvoiceMasterDTO.getInvoicePDF());
			ps.setBlob(4, InvoiceMasterDTO.getInvoiceExcel());
			ps.setString(5, InvoiceMasterDTO.getInvoiceid());
			i=ps.executeUpdate();
			DBUtility1.closeConnection(null, null);
			return i;
			
		}catch(Exception e){
			DBUtility1.closeConnection(e, null);
			return i;
		}
	}

	@Override
	public int deleteItemByID(String invoiceid) {
		Connection con=DBUtility1.getConnection(dbConfigProp);
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("DELETE FROM invoiceblob WHERE invoiceid=?;");
			ps.setString(1,invoiceid);
			i=ps.executeUpdate();
			DBUtility1.closeConnection(null, null);
			return i;
		}catch(Exception e){
			DBUtility1.closeConnection(e, null);
			return i;
		}
	}

	@Override
	public int deleteItemByDTO(InvoiceMasterDTO InvoiceMasterDTO) {
		Connection con=DBUtility1.getConnection(dbConfigProp);
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("DELETE FROM invoiceblob WHERE invoiceid=?;");
			ps.setString(1,InvoiceMasterDTO.getInvoiceid());
			i=ps.executeUpdate();
			DBUtility1.closeConnection(null, null);
			return i;
		}catch(Exception e){
			DBUtility1.closeConnection(e, null);
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
