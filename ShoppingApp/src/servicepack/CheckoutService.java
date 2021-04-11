package servicepack;

import java.util.ArrayList;
import java.util.Map;

import com.itextpdf.text.Document;

public interface CheckoutService {
	public void generatePDF(String invoiceNumber,Map<String,String> companyAddress,Map<String,String> billingAddress,Map<String,ArrayList<Float>> products,float discount,float tax,String filepath);
	public void generateExcel(String invoiceNumber,Map<String,String> companyAddress,Map<String,String> billingAddress,Map<String,ArrayList<Float>> products,float discount,float tax,String filepath);
	public void sendEmail(String to[],String subject,String body,String filenamePDF,String filenameExcel) throws Exception;
	public void storeInvoice(String invoiceno,String date,int uid,String invoicePDF,String invoiceExcel);
}
