package sample;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;

@HandlerChain(file="handler.xml")
@WebService
public interface HelloService {
	@WebMethod
	public String sayHello(String name);
}
