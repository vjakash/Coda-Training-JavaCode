package day16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadedClient {
	Socket s;BufferedReader br,in;PrintWriter out;ExecutorService es;
	public MultiThreadedClient() throws Exception{
//		while(true) {
			s=new Socket("localhost",2000);
			s.setKeepAlive(true);
			es=Executors.newFixedThreadPool(2);
			es.execute(()->{
				while(true) {
						
					try {
						br=new BufferedReader(new InputStreamReader(s.getInputStream()));
						String msg=br.readLine();
						System.out.println("Message from server...:"+msg);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			});
			es.execute(()->{
				while(true) {
					try {
						out=new PrintWriter(s.getOutputStream(),true);
						in=new BufferedReader(new InputStreamReader(System.in));
						System.out.println("Type a message to server..:");
						String msgToServer=in.readLine();
						out.println(msgToServer);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
			});
			es.shutdown();
			
			
			
			
//		}
	}
	public static void main(String[] args) throws Exception {
		new MultiThreadedClient();
	}
}
