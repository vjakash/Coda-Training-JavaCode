package sample;

import javax.xml.ws.Endpoint;

import headerUnamePassAuth.HelloWorldImpl;

public class PublishService {
	public static void main(String[] args) {
		HelloService myservice=new HelloServiceImpl();
		
		Endpoint.publish("http://localhost:8080/ws/helloService", myservice);
//		Endpoint.publish("http://localhost:8080/ws/helloService", new HelloWorldImpl());
		
		System.out.println("Service Published....");
	}
}
