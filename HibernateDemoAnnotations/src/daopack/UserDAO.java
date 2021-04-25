package daopack;

import java.util.Set;

public interface UserDAO {
	public User findById(int uid);
	public Set<User> findAll();
	public int insertUser(User user);
	public int deleteUser(int uid);
	public int updateUser(User User);
	public User findByName(String uname);
}
