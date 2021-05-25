package com.services;

import java.util.ArrayList;
import java.util.Map;

import org.json.JSONObject;

import com.model.User;

public interface PaymentService {
	public JSONObject createOrder(String total,User user);
	public void generatePDF(String invoiceNumber,Map<String,String> companyAddress,Map<String,String> billingAddress,Map<String,ArrayList<Float>> products,float discount,float tax,String filepath);
	public void generateExcel(String invoiceNumber,Map<String,String> companyAddress,Map<String,String> billingAddress,Map<String,ArrayList<Float>> products,float discount,float tax,String filepath);
	public void sendEmail(String to[],String subject,String body,String filenamePDF,String filenameExcel) throws Exception;
	public void storeInvoice(String invoiceno,String date,int uid,String invoicePDF,String invoiceExcel);
}
