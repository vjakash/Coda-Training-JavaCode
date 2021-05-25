package com.services;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.model.User;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.utilities.ExcelGenerator;
import com.utilities.PDFGenerator;
import com.utilities.SendMail;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

	@Override
	public JSONObject createOrder(String total,User user) {
		Order order =null;
		JSONObject jsonObject=null;
		try {
			RazorpayClient razorpayClient = new RazorpayClient("rzp_test_S4S8eULZMZ5Pyo", "aQICXkSYDgUXV1oqfBy69pRc"); 
			  JSONObject orderRequest = new JSONObject();
			  orderRequest.put("amount", Float.valueOf(total)*100); // amount in the smallest currency unit
			  orderRequest.put("currency", "INR");
			  orderRequest.put("receipt", "order_rcptid_11");

			  order = razorpayClient.Orders.create(orderRequest);
			  System.out.println(order);
			 
			  jsonObject=new JSONObject(String.valueOf(order));
			  jsonObject.put("phone", user.getMobile());
			  jsonObject.put("email", user.getEmail());
			  jsonObject.put("name", user.getUsername());
			} catch (RazorpayException e) {
			  // Handle Exception
			  System.out.println(e.getMessage());
			}
		return jsonObject;
	}

	@Override
	public void generatePDF(String invoiceNumber, Map<String, String> companyAddress,
			Map<String, String> billingAddress, Map<String, ArrayList<Float>> products, float discount, float tax,
			String filepath) {
		PDFGenerator generator=new PDFGenerator();
		generator.generate(invoiceNumber, companyAddress, billingAddress, products, discount, tax,filepath);
		
	}

	@Override
	public void generateExcel(String invoiceNumber, Map<String, String> companyAddress,
			Map<String, String> billingAddress, Map<String, ArrayList<Float>> products, float discount, float tax,
			String filepath) {
		ExcelGenerator generator=new ExcelGenerator();
		generator.generate(invoiceNumber, companyAddress, billingAddress, products, discount, tax,filepath);
		
	}

	@Override
	public void sendEmail(String[] to, String subject, String body, String filenamePDF, String filenameExcel)
			throws Exception {
		try {
			SendMail maileSender=new SendMail();
			maileSender.sendMail(to, subject, body, filenamePDF,filenameExcel);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	@Override
	public void storeInvoice(String invoiceno, String date, int uid, String invoicePDF, String invoiceExcel) {
		// TODO Auto-generated method stub
		
	}

}
