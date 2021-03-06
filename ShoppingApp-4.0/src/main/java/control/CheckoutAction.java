package control;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import invoicePack.PDFGenerator;
import servicepack.CheckoutServiceImpl;

public class CheckoutAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String invoiceNumber=String.valueOf(Math.random()).substring(2,10);
		float discount=3f;
		float  tax=18f;
		Map<String,String> companyAddress=new HashMap<String, String>();
		companyAddress.put("name", "Presidio");
		companyAddress.put("doorno", "8th floor");
		companyAddress.put("street", "coda street");
		companyAddress.put("area", "guindy");
		companyAddress.put("city", "chennai");
		companyAddress.put("pincode", "600087");
		
		HttpSession session=request.getSession();
		Map<String,ArrayList<Float>> cart=(Map<String,ArrayList<Float>>)session.getAttribute("cart");
		Map<String,String> deliveryAddress=(Map<String,String>)session.getAttribute("deliveryAddress");
		
		Properties prop=(Properties)request.getServletContext().getAttribute("configProp");
		String filepath=request.getServletContext().getRealPath((String) prop.get("pdffolder"));
		System.out.println(invoiceNumber+" "+filepath);
		
		CheckoutServiceImpl checkoutServiceImpl=new CheckoutServiceImpl((Properties)request.getServletContext().getAttribute("dbConfigProp"));
		
		checkoutServiceImpl.generatePDF(invoiceNumber, companyAddress, deliveryAddress, cart, discount, tax,filepath);
		checkoutServiceImpl.generateExcel(invoiceNumber, companyAddress, deliveryAddress, cart, discount, tax,filepath);
		
		int Uid=(int) session.getAttribute("Uid");
		checkoutServiceImpl.storeInvoice(invoiceNumber, LocalDateTime.now().toLocalDate().toString(), Uid, filepath+"/"+invoiceNumber+".pdf", filepath+"/"+invoiceNumber+".xlsx");
		
		String email=(String) session.getAttribute("email");
		try {			
			checkoutServiceImpl.sendEmail(new String[] {email}, "Invoice for your order", "", filepath+"/"+invoiceNumber+".pdf", filepath+"/"+invoiceNumber+".xlsx"); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.removeAttribute("cart");
		session.removeAttribute("deliveryAddress");
		session.removeAttribute("email");
		return "order.placed";
	}
}
