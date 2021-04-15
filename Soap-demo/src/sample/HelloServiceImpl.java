package sample;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(endpointInterface = "sample.HelloService")
public class HelloServiceImpl implements HelloService{
	
	@WebMethod
	@Override
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		return "Welcome to SOAP based Web Services....:"+name;
	}
}
