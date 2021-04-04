package invoice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UIInvoiceGenerator {
	public static void main(String[] args) {
		String invoiceNumber="5765765764577";
		float discount=10f;
		float  tax=9f;
		Map<String,String> companyAddress=new HashMap<String, String>();
		companyAddress.put("doorno", "8th floor");
		companyAddress.put("street", "coda street");
		companyAddress.put("area", "guindy");
		companyAddress.put("city", "chennai");
		companyAddress.put("pincode", "600087");
		
		Map<String,String> billingAddress=new HashMap<String, String>();
		billingAddress.put("name", "A.Vijay Akash");
		billingAddress.put("doorno", "3/961-3");
		billingAddress.put("street", "global street");
		billingAddress.put("area", "ramapuram");
		billingAddress.put("city", "chennai");
		billingAddress.put("pincode", "600087");
		
		Map<String,ArrayList<Float>> products= new HashMap<String,ArrayList<Float>>();
		for(int i=0;i<5;i++) {
			ArrayList<Float> list=new ArrayList<Float>();
			list.add(2f);
			list.add(120f);
			products.put("Apple"+i, list);
		}
		
		PDFGenerator generator=new PDFGenerator();
		generator.generate(invoiceNumber, companyAddress, billingAddress, products, discount, tax);
	}
}
