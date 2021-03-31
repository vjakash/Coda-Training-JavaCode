package day16;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import org.apache.commons.collections4.map.HashedMap;

public class MultiThreadedServer {
	ServerSocket socketServer;Socket socket;ExecutorService es;BufferedReader br,in;PrintWriter out;
	Map<SocketAddress,Socket > connectedSockets=new HashedMap<SocketAddress, Socket>();
	public MultiThreadedServer() throws Exception{
		socketServer=new ServerSocket(2000);
		System.out.println("Server ready on port 2000");
//		while(true) {
			es=Executors.newFixedThreadPool(2);
			es.execute(()->{
				while(true) {
					try {					
						socket=socketServer.accept();
						connectedSockets.put(socket.getRemoteSocketAddress(), socket);
						startSocket(socket);
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
				
			});
			es.execute(()->{
				while(true) {
					try {
						in=new BufferedReader(new InputStreamReader(System.in));
						System.out.println("Enter Message For Client..:");
						String msgToClient = null;
						msgToClient = in.readLine();
						if(msgToClient!=null) {
							for(Map.Entry<SocketAddress, Socket> s:connectedSockets.entrySet()) {
														
									out=new PrintWriter(s.getValue().getOutputStream(),true);
								
									out.println(msgToClient);
								
							}
						}
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});
			es.shutdown();
//		}
	}
	public static  void startSocket(Socket s)throws Exception{
		ExecutorService es=Executors.newFixedThreadPool(1);
		es.execute(()->{
			while(true) {
				try {	
					if(s.isConnected()) {
						BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
						String msg=br.readLine();
						if(msg==null) break;
						System.out.println("Message From Client..:"+msg);
					}else {
						break;
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		});
		es.shutdown();
	}
	public static void main(String[] args)throws Exception {
		new MultiThreadedServer();
	}
}
