package daopack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Set;




public class UserDAOImpl implements UserDAO,Cloneable{
	private static Properties dbConfigProp;
	private UserDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	private static UserDAOImpl userDaoImpl;
	
	public static UserDAOImpl getUserDaoImpl(Properties dbConProp) {
		dbConfigProp=dbConProp;
		if(userDaoImpl==null) {
			userDaoImpl=new UserDAOImpl();
		}
		return userDaoImpl.getClone();
	}
	
	public UserDAOImpl getClone() {
		try {
			return (UserDAOImpl)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public UserDTO findById(int uid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<UserDTO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(int uid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(UserDTO userDTO) {
		Connection con=DBUtility1.getConnection(dbConfigProp);
		int i=0;
		try {
			PreparedStatement ps=con.prepareStatement("UPDATE users SET username=?,password=?,flag=? WHERE userid=?;");
			ps.setString(1, userDTO.getUname());
			ps.setString(2, userDTO.getUpass());
			ps.setInt(3, userDTO.getFlag());
			ps.setInt(4,userDTO.getUid());
			i=ps.executeUpdate();
			DBUtility1.closeConnection(null, null);
			return i;
			
		}catch(Exception e){
			DBUtility1.closeConnection(e, null);
			return i;
		}
	}

	@Override
	public UserDTO findByName(String uname) {
		UserDTO item=null;
		Connection con=DBUtility1.getConnection(dbConfigProp);
		try {
			PreparedStatement ps=con.prepareStatement("SELECT * FROM users WHERE username=?");
			ps.setString(1, uname);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				item=UserDTO.getUserDTO();
				item.setUid(rs.getInt(1));
				item.setUname(rs.getString(2));
				item.setUpass(rs.getString(3));
				item.setFlag(rs.getInt(4));
			}
			DBUtility1.closeConnection(null, null);
			return item;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			DBUtility1.closeConnection(e, null);
			e.printStackTrace();
			return item;
		}
	}

}
