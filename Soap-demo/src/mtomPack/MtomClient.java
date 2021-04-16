package mtomPack;

import java.awt.Image;
import java.io.File;
import java.net.URL;

import javax.xml.ws.soap.SOAPBinding;
import javax.imageio.ImageIO;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;


public class MtomClient{
	public static void main(String[] args) throws Exception {
		
		URL url = new URL("http://localhost:8888/ws/hello?wsdl"); 
		QName qname = new QName("http://mtomPack/", "MtomServiceService");
		Service service = Service.create(url, qname);
		MtomInter mtom=service.getPort(MtomInter.class); 
		
		BindingProvider bp = (BindingProvider) mtom;
		SOAPBinding binding = (SOAPBinding) bp.getBinding();
		binding.setMTOMEnabled(true);
		
		Image img=ImageIO.read(new File("flower.jpg"));
		mtom.setImage(img,"earrings.jpg"); 
	}
}