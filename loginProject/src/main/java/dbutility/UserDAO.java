package dbutility;


import java.util.List;

public interface UserDAO {
	public UserDTO findByID(Integer userid) throws Exception;
	public List<UserDTO> findAll();
	public int insertUser(UserDTO userDTO);
	public int updateUser(UserDTO userDTO);
	public int deleteUserByID(Integer userid);
	public int deleteUserByDTO(UserDTO userDTO);
	public UserDTO findByUsername(String username);
	public int UpdateFlag(int userid,int flag);
}
