package headerUnamePassAuth;

//public class UnamePassAuthClient {
//
//}
import java.net.URL;
import java.util.Collections; import java.util.HashMap; import java.util.List;
import java.util.Map;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;

import sample.HelloService;
//import com.myservice.HelloWorld; 

public class UnamePassAuthClient{
	
	private static final String WS_URL = "http://localhost:8080/ws/helloService?wsdl";
	
	public static void main(String[] args) throws Exception {
		URL url = new URL(WS_URL); 
		QName qname = new QName("http://headerUnamePassAuth/","HelloWorldImplService");
		Service service = Service.create(url, qname);
		HelloService hello = service.getPort(HelloService.class);
		
		/*******************UserName & Password******************************/
		Map<String, Object> req_ctx = ((BindingProvider)hello).getRequestContext();
		req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY , WS_URL);
		Map<String, List<String>> headers = new HashMap<String, List<String>>();
		headers.put("Username", Collections.singletonList("ramu"));
		headers.put("Password", Collections.singletonList("secret"));
		req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);
		/**********************************************************************/
		System.out.println(hello.sayHello("coda")); 
	}
}