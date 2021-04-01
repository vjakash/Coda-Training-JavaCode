package day19;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import day18.DBUtility;

public class ItemMasterDAOImpl implements ItemMasterDAO {

	@Override
	public ItemDTO findByID(Integer itemid) throws SQLException {
		ItemDTO item=null;
		Connection con=DBUtility.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("SELECT * FROM itemmaster WHERE itemid=?");
			ps.setInt(1, itemid);
			ResultSet rs=ps.executeQuery();
			
//			ResultSetMetaData rsmd=rs.getMetaData();
//			int colCount=rsmd.getColumnCount();
			
			while(rs.next()) {
				item=ItemDTO.getItemDTO();
				item.setItemid(rs.getInt(1));
				item.setItem_name(rs.getString(2));
				item.setItem_unit(rs.getString(3));
				item.setPrice(rs.getFloat(4));
			}
			DBUtility.closeConnection(null, null);
			return item;
		}catch(Exception e) {
			DBUtility.closeConnection(e, null);
			return item;
		}	
	}

	@Override
	public List<ItemDTO> findAll() {
		List<ItemDTO> itemList=null;
		Connection con=DBUtility.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("SELECT * FROM itemmaster;");
			ResultSet rs=ps.executeQuery();
			

			while(rs.next()) {
				itemList=new ArrayList<ItemDTO>();
				ItemDTO item=ItemDTO.getItemDTO();
				item=ItemDTO.getItemDTO();
				item.setItemid(rs.getInt(1));
				item.setItem_name(rs.getString(2));
				item.setItem_unit(rs.getString(3));
				item.setPrice(rs.getFloat(4));
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
	public int insertItem(ItemDTO itemDTO) {
		Connection con=DBUtility.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("INSERT INTO itemmaster VALUES(?,?,?,?)");
			ps.setInt(1,itemDTO.getItemid());
			ps.setString(2, itemDTO.getItem_name());
			ps.setString(3, itemDTO.getItem_unit());
			ps.setFloat(4, itemDTO.getPrice());
			int i=ps.executeUpdate();
			DBUtility.closeConnection(null, null);
			return i;
			
		}catch(Exception e){
			DBUtility.closeConnection(e, null);
			return 0;
		}
	}

	@Override
	public int updateItem(ItemDTO itemDTO) {
		Connection con=DBUtility.getConnection();
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("UPDATE itemmaster SET item_name=?,item_unit=?,price=? WHERE itemid=?;");
			ps.setString(1, itemDTO.getItem_name());
			ps.setString(2, itemDTO.getItem_unit());
			ps.setFloat(3, itemDTO.getPrice());
			ps.setInt(4,itemDTO.getItemid());
			i=ps.executeUpdate();
			DBUtility.closeConnection(null, null);
			return i;
			
		}catch(Exception e){
			DBUtility.closeConnection(e, null);
			return i;
		}
	}

	@Override
	public int deleteItemByID(Integer itemid) {
		Connection con=DBUtility.getConnection();
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("DELETE FROM itemmaster WHERE itemid=?;");
			ps.setInt(1,itemid);
			i=ps.executeUpdate();
			DBUtility.closeConnection(null, null);
			return i;
		}catch(Exception e){
			DBUtility.closeConnection(e, null);
			return i;
		}
	}

	@Override
	public int deleteItemByDTO(ItemDTO itemDTO) {
		Connection con=DBUtility.getConnection();
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("DELETE FROM itemmaster WHERE itemid=?;");
			ps.setInt(1,itemDTO.getItemid());
			i=ps.executeUpdate();
			DBUtility.closeConnection(null, null);
			return i;
		}catch(Exception e){
			DBUtility.closeConnection(e, null);
			return i;
		}
	}
//	public static void main(String[] args) throws Exception{
//		ItemMasterDAOImpl imi=new ItemMasterDAOImpl();
//		
//		ItemDTO item1=ItemDTO.getItemDTO();
//		item1.setItemid(001);
//		item1.setItem_name("Daal");
//		item1.setItem_unit("kg");
//		item1.setPrice(100.50f);
//		
//		ItemDTO item2=ItemDTO.getItemDTO();
//		item2.setItemid(002);
//		item2.setItem_name("Rice");
//		item2.setItem_unit("kg");
//		item2.setPrice(200.10f);
//		
//		imi.insertItem(item1);
//		imi.insertItem(item2);
//		
//		ItemDTO item= imi.findByID(001);
//		System.out.println(item);
//		
//		item1.setItem_name("Noodles");
//		imi.updateItem(item1);
//		item= imi.findByID(001);
//		System.out.println(item);
//		
//		List<ItemDTO> itemList=imi.findAll();
//		System.out.println(itemList);
//		
//		imi.deleteItemByID(001);
//		item= imi.findByID(001);
//		System.out.println(item);
//	}

}
