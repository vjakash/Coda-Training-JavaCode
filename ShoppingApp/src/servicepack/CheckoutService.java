package servicepack;

import java.util.ArrayList;
import java.util.Map;

public interface CheckoutService {
	public void generatePDF(String invoiceNumber,Map<String,String> companyAddress,Map<String,String> billingAddress,Map<String,ArrayList<Float>> products,float discount,float tax,String filepath);
	public void sendEmail(String to[],String subject,String body,String filename) throws Exception;
	
}
