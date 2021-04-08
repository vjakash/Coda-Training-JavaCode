package servicepack;

import java.util.ArrayList;
import java.util.Map;

import emailPack.SendMail;
import invoicePack.PDFGenerator;

public class CheckoutServiceImpl implements CheckoutService{

	@Override
	public void generatePDF(String invoiceNumber, Map<String, String> companyAddress,
			Map<String, String> deliveryAddress, Map<String, ArrayList<Float>> cart, float discount, float tax,String filepath) {
		
		PDFGenerator generator=new PDFGenerator();
		generator.generate(invoiceNumber, companyAddress, deliveryAddress, cart, discount, tax,filepath);
	}

	@Override
	public void sendEmail(String to[],String subject,String body,String filename) {
		try {
			SendMail maileSender=new SendMail();
			maileSender.sendMail(to, subject, body, filename);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
}
