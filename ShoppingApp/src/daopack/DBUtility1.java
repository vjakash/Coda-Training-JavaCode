package daopack;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Savepoint;
import java.util.Properties;

public class DBUtility1 {
	static Properties  dbConfigProp=null;
	private DBUtility1() {
		
	}
	private static String url,username,password;
	static {
		try {
//			Properties prop=new Properties();
//			prop.load(new FileInputStream("dbconfig.properties"));
//			String driver=dbConfigProp.getProperty("driver");
//			url=dbConfigProp.getProperty("url");
//			username=dbConfigProp.getProperty("username");
//			password=dbConfigProp.getProperty("password");
//			Class.forName(driver);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static ThreadLocal<Connection> tlocal=new ThreadLocal<>();
	private static Connection con;
	synchronized public static Connection getConnection(Properties prop) {
		dbConfigProp=prop;
		System.out.println(dbConfigProp);
		con=tlocal.get();
		if(con==null) {
			try {
				String driver=dbConfigProp.getProperty("driver");
				url=dbConfigProp.getProperty("url");
				username=dbConfigProp.getProperty("username");
				password=dbConfigProp.getProperty("password");
				Class.forName(driver);
				con=DriverManager.getConnection(url,username,password);
				con.setAutoCommit(false);
				tlocal.set(con);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	synchronized public static void closeConnection(Exception e,Savepoint sp) {
		con=tlocal.get();
		if(con!=null) {
			try {
				if(e==null) {
					con.commit();//manual commit
				}
				else {
					if(sp==null) {
						con.rollback();
					}
					else {
						con.rollback(sp);
						con.commit();
					}
				}
			con.close();
			tlocal.remove();
			}catch(Exception ee) {
				ee.printStackTrace();
			}
		}
	}
}
