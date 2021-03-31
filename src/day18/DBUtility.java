package day18;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;
import java.util.Properties;
public class DBUtility {
	private DBUtility() {
		// TODO Auto-generated constructor stub
	}
	private static String url,username,password;
	static {
		try {
			Properties prop=new Properties();
			prop.load(new FileInputStream("dbconfig.properties"));
			String driver=prop.getProperty("driver");
			url=prop.getProperty("url");
			username=prop.getProperty("username");
			password=prop.getProperty("password");
			Class.forName(driver);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static ThreadLocal<Connection> tlocal=new ThreadLocal<>();
	private static Connection con;
	synchronized public static Connection getConnection() {
		con=tlocal.get();
		if(con==null) {
			try {
				con=DriverManager.getConnection(url,username,password);
				con.setAutoCommit(false);//default is true
				tlocal.set(con);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	synchronized public static void closeConnection(Exception exp,Savepoint sp) {
		con=tlocal.get();
		if(con!=null) {
			try {
				if(exp!=null) {//if exception rollback
					if(sp==null) {
						con.rollback();
					}else {
						con.rollback(sp);
					}
				}
			con.commit();//manual commit
			con.close();
			tlocal.remove();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
