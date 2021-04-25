package daopack;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import manytomany.Student;
import manytomany.Training;
import utility.HibernateUtility;

public class UserDAOImpl implements UserDAO,Cloneable{

	private UserDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	private static UserDAOImpl userDaoImpl;
	
	public static UserDAOImpl getUserDaoImpl() {
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
	public User findById(int uid) {
		
		return null;
	}

	@Override
	public Set<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(int uid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(User user) {
		Session session=HibernateUtility.getSession();
		Query q=session.createQuery("update User user set username=:uname,password=:pword,flag=:f where user.userid=:userid");
		q.setParameter("uname", user.getUsername());
		q.setParameter("pword", user.getPassword());
		q.setParameter("f", user.getFlag());
		q.setParameter("userid", user.getUserid());
		int updateditems=q.executeUpdate();
		HibernateUtility.closeSession(null);
		return updateditems;
	}

	@Override
	public User findByName(String uname) {

		User user=null;
		
		Session session= HibernateUtility.getSession();
		Query query=session.createQuery("from User user where user.username=:uname");
		query.setParameter("uname", uname);
		List list=query.list();
		if(list.size()!=0) {			
			user=(User)list.get(0);
		}
		HibernateUtility.closeSession(null);
		return user;
	}
	public static void main(String[] args) {
//		UserDAOImpl u=UserDAOImpl.getUserDaoImpl();
//		u.findByName("vijay1");
//		User user=new User();
//		user.setFlag(0);
//		user.setPassword("abcd");
//		user.setUsername("vijay");
//		user.setUserid(1);
//		
//		int i=u.updateUser(user);
//		System.out.println(i);
	}
}
