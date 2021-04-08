package dbutility;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

public class UserDAOImpl implements UserDAO {

		@Override
		public UserDTO findByUsername(String username) {
			UserDTO item=null;
			Connection con=DBUtility.getConnection();
			try {
				PreparedStatement ps=con.prepareStatement("SELECT * FROM userdata WHERE username=?");
				ps.setString(1, username);
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					item=UserDTO.getUserDTO();
					item.setUserid(rs.getInt(1));
					item.setUsername(rs.getString(2));
					item.setPassword(rs.getString(3));
					item.setEmail(rs.getString(4));
					item.setDob(rs.getString(5));
					item.setAge(rs.getInt(6));
					item.setPhone(rs.getString(7));
					item.setFlag(rs.getInt(8));
				}
				DBUtility.closeConnection(null, null);
				return item;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				DBUtility.closeConnection(e, null);
				e.printStackTrace();
				return item;
			}
		}
	@Override
	public UserDTO findByID(Integer userid) throws SQLException {
		UserDTO item=null;
		Connection con=DBUtility.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("SELECT * FROM userdata WHERE userid=?");
			ps.setInt(1, userid);
			ResultSet rs=ps.executeQuery();
			
//			ResultSetMetaData rsmd=rs.getMetaData();
//			int colCount=rsmd.getColumnCount();
			
			while(rs.next()) {
				item=UserDTO.getUserDTO();
				item.setUserid(rs.getInt(1));
				item.setUsername(rs.getString(2));
				item.setPassword(rs.getString(3));
				item.setEmail(rs.getString(4));
				item.setDob(rs.getString(5));
				item.setAge(rs.getInt(6));
				item.setPhone(rs.getString(7));
				item.setFlag(rs.getInt(8));
			}
			DBUtility.closeConnection(null, null);
			return item;
		}catch(Exception e) {
			DBUtility.closeConnection(e, null);
			return item;
		}	
	}

	@Override
	public List<UserDTO> findAll() {
		List<UserDTO> itemList=null;
		Connection con=DBUtility.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("SELECT * FROM userdata;");
			ResultSet rs=ps.executeQuery();
			
//			ResultSetMetaData rsmd=rs.getMetaData();

			while(rs.next()) {
				itemList=new ArrayList<UserDTO>();
				UserDTO item=UserDTO.getUserDTO();
				item.setUserid(rs.getInt(1));
				item.setUsername(rs.getString(2));
				item.setPassword(rs.getString(3));
				item.setEmail(rs.getString(4));
				item.setDob(rs.getString(5));
				item.setAge(rs.getInt(6));
				item.setPhone(rs.getString(7));
				item.setFlag(rs.getInt(8));
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
	public int insertUser(UserDTO userDTO) {
		Connection con=DBUtility.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("INSERT INTO userdata VALUES(?,?,?,?,?,?,?,?)");
			ps.setInt(1,userDTO.getUserid());
			ps.setString(2, userDTO.getUsername());
			ps.setString(3, userDTO.getPassword());
			ps.setString(4, userDTO.getEmail());
			ps.setString(5, userDTO.getDob());
			ps.setInt(6,userDTO.getAge());
			ps.setString(7, userDTO.getPhone());
			ps.setInt(8, userDTO.getFlag());
			int i=ps.executeUpdate();
			DBUtility.closeConnection(null, null);
			return i;
			
		}catch(Exception e){
			DBUtility.closeConnection(e, null);
			return 0;
		}
	}

	@Override
	public int updateUser(UserDTO userDTO) {
		Connection con=DBUtility.getConnection();
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("UPDATE users SET username=?,password=?,email=?,dob=?,age=?,phone=?,flag=? WHERE userid=?;");
			ps.setString(1, userDTO.getUsername());
			ps.setString(2, userDTO.getPassword());
			ps.setString(3, userDTO.getEmail());
			ps.setString(4, userDTO.getDob());
			ps.setInt(5,userDTO.getAge());
			ps.setString(6, userDTO.getPhone());
			ps.setInt(7, userDTO.getFlag());
			ps.setInt(8,userDTO.getUserid());
			i=ps.executeUpdate();
			DBUtility.closeConnection(null, null);
			return i;
			
		}catch(Exception e){
			DBUtility.closeConnection(e, null);
			return i;
		}
	}
	@Override
	public int UpdateFlag(int userid,int flag) {
		Connection con=DBUtility.getConnection();
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("UPDATE userdata SET flag=? WHERE userid=?;");
			 ps.setInt(1, flag);
			 ps.setInt(2,userid);
			 i=ps.executeUpdate();
			DBUtility.closeConnection(null, null);
			return i;
			
		}catch(Exception e){
			DBUtility.closeConnection(e, null);
			return i;
		}		
	}
	@Override
	public int deleteUserByID(Integer userid) {
		Connection con=DBUtility.getConnection();
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("DELETE FROM userdata WHERE userid=?;");
			ps.setInt(1,userid);
			i=ps.executeUpdate();
			DBUtility.closeConnection(null, null);
			return i;
		}catch(Exception e){
			DBUtility.closeConnection(e, null);
			return i;
		}
	}

	@Override
	public int deleteUserByDTO(UserDTO userDTO) {
		Connection con=DBUtility.getConnection();
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("DELETE FROM userdata WHERE userid=?;");
			ps.setInt(1,userDTO.getUserid());
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
//		
//	}

}
