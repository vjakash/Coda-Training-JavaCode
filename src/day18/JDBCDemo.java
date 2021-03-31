package day18;
//start server in system pref
//mysql --user=root -p
//alias mysql=/usr/local/mysql/bin/mysql
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDemo {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/coda","root","01200340");
		System.out.println(con);
	}
}
