package day19;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import day18.DBUtility;

public class UserDAOImpl implements UserDAO {

	@Override
	public UserDTO findByID(Integer userid) throws SQLException {
		UserDTO item=null;
		Connection con=DBUtility.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("SELECT * FROM users WHERE userid=?");
			ps.setInt(1, userid);
			ResultSet rs=ps.executeQuery();
			
//			ResultSetMetaData rsmd=rs.getMetaData();
//			int colCount=rsmd.getColumnCount();
			
			while(rs.next()) {
				item=UserDTO.getUserDTO();
				item.setUserid(rs.getInt(1));
				item.setUsername(rs.getString(2));
				item.setPassword(rs.getString(3));
				item.setFlag(rs.getInt(4));
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
			PreparedStatement ps=con.prepareStatement("SELECT * FROM users;");
			ResultSet rs=ps.executeQuery();
			
//			ResultSetMetaData rsmd=rs.getMetaData();

			while(rs.next()) {
				itemList=new ArrayList<UserDTO>();
				UserDTO item=UserDTO.getUserDTO();
				item.setUserid(rs.getInt(1));
				item.setUsername(rs.getString(2));
				item.setPassword(rs.getString(3));
				item.setFlag(rs.getInt(4));
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
			PreparedStatement ps=con.prepareStatement("INSERT INTO users VALUES(?,?,?,?)");
			ps.setInt(1,userDTO.getUserid());
			ps.setString(2, userDTO.getUsername());
			ps.setString(3, userDTO.getPassword());
			ps.setInt(4, userDTO.getFlag());
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
			PreparedStatement ps=con.prepareStatement("UPDATE users SET username=?,password=?,flag=? WHERE userid=?;");
			ps.setString(1, userDTO.getUsername());
			ps.setString(2, userDTO.getPassword());
			ps.setInt(3, userDTO.getFlag());
			ps.setInt(4, userDTO.getUserid());
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
			PreparedStatement ps=con.prepareStatement("DELETE FROM users WHERE userid=?;");
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
			PreparedStatement ps=con.prepareStatement("DELETE FROM users WHERE userid=?;");
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
