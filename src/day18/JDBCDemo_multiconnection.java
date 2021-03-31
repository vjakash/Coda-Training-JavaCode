package day18;

import java.sql.Connection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class JDBCDemo_multiconnection {
	public static void main(String[] args) {
		ExecutorService es=Executors.newFixedThreadPool(2);
		
		es.execute(()->{
			Connection con=DBUtility.getConnection();
			System.out.println("thread 1 con1 "+con);
			DBUtility.closeConnection(null,null);
			
			Connection con2=DBUtility.getConnection();
			System.out.println("thread 1 con2 "+con2);
		});
		es.execute(()->{
			Connection con=DBUtility.getConnection();
			System.out.println("thread 2 con1 "+con);
			Connection con2=DBUtility.getConnection();
			System.out.println("thread 2 con2 "+con2);
		});
		es.shutdown();
	}
}