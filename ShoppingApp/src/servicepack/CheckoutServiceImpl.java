package servicepack;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Properties;


import daopack.InvoiceMasterDAOImpl;
import daopack.InvoiceMasterDTO;
import emailPack.SendMail;
import invoicePack.ExcelGenerator;
import invoicePack.PDFGenerator;

public class CheckoutServiceImpl implements CheckoutService{
	Properties dbConfigProp;
	public CheckoutServiceImpl(Properties dbConfig) {
		// TODO Auto-generated constructor stub
		dbConfigProp=dbConfig;
	}
	@Override
	public void generatePDF(String invoiceNumber, Map<String, String> companyAddress,
			Map<String, String> deliveryAddress, Map<String, ArrayList<Float>> cart, float discount, float tax,String filepath) {
		
		PDFGenerator generator=new PDFGenerator();
		generator.generate(invoiceNumber, companyAddress, deliveryAddress, cart, discount, tax,filepath);
	}
	
	@Override
	public void generateExcel(String invoiceNumber, Map<String, String> companyAddress,
			Map<String, String> deliveryAddress, Map<String, ArrayList<Float>> cart, float discount, float tax,String filepath) {
		
		ExcelGenerator generator=new ExcelGenerator();
		generator.generate(invoiceNumber, companyAddress, deliveryAddress, cart, discount, tax,filepath);
	}
	
	@Override
	public void sendEmail(String to[],String subject,String body,String filenamePDF,String filenameExcel) {
		try {
			SendMail maileSender=new SendMail();
			maileSender.sendMail(to, subject, body, filenamePDF,filenameExcel);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void storeInvoice(String invoiceno,String date,int uid,String invoicePDF,String invoiceExcel) {
		InvoiceMasterDAOImpl invoiceMasterDAOImpl=InvoiceMasterDAOImpl.getItemMasterDaoImpl(dbConfigProp);
		InvoiceMasterDTO item=InvoiceMasterDTO.getInvoiceMasterDTO();
		item.setInvoiceid(invoiceno);
		item.setInvoicedate(date);
		item.setUid(uid);
		try {
			item.setInvoicePDF(getByteArrayInpputStreamFromFile(invoicePDF));
			item.setInvoiceExcel(getByteArrayInpputStreamFromFile(invoiceExcel));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		invoiceMasterDAOImpl.insertItem(item);
//		InvoiceMasterDTO retrievedItem=invoiceMasterDAOImpl.findByID(invoiceno);
//		storeStreamLocally(invoiceno, retrievedItem.getInvoicePDF(),retrievedItem.getInvoiceExcel());
	}

	private ByteArrayInputStream getByteArrayInpputStreamFromFile(String handledDocument) throws IOException {
	    final ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    final InputStream in = new FileInputStream(handledDocument);
	    final byte[] buffer = new byte[500];

	    int read = -1;
	    while ((read = in.read(buffer)) > 0) {
	        baos.write(buffer, 0, read);
	    }
	    in.close();
	   
	    return  new ByteArrayInputStream(baos.toByteArray());
	}
	private void storeStreamLocally(String invoicenum,ByteArrayInputStream baisPDF,ByteArrayInputStream baisExcel) {
		try {
//			 InputStream initialStream = new FileInputStream(bais);
//		     byte[] buffer = new byte[initialStream.available()];
//			 initialStream.read(buffer);
//
//		     File targetFile = new File("src/main/resources/targetFile.tmp");
//			 FileOutputStream outStream = new FileOutputStream(targetFile);
//			 outStream.write(buffer);
			 InputStream in = baisPDF;
			 OutputStream out = new FileOutputStream("/Users/vj/eclipse-workspace/invoices/"+invoicenum+".pdf");
			 
			// Transfer bytes from in to out
			byte[] buf = new byte[1024];
			int len;
			while ((len = in.read(buf)) > 0) {
				out.write(buf, 0, len);
			}
			in.close();
			out.close();
			System.out.println("pdf file stored locally");
			
			 InputStream in1 = baisExcel;
			 OutputStream out1 = new FileOutputStream("/Users/vj/eclipse-workspace/invoices/"+invoicenum+".xlsx");
			 
			// Transfer bytes from in to out
			byte[] buf1 = new byte[1024];
			int len1;
			while ((len1 = in.read(buf)) > 0) {
				out1.write(buf, 0, len1);
			}
			in1.close();
			out1.close();
			System.out.println("Excel file stored locally");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
