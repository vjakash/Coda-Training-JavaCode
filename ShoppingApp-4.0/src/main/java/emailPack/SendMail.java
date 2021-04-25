package emailPack;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendMail {
	Session newSession;MimeMessage mimeMessage;
	 public SendMail() {
		// TODO Auto-generated constructor stub
	}
	public void sendMail(String to[],String subject,String body,String filenamePDF,String filenameExcel) throws Exception {
		setupServerProperties();
		draftMail(to,subject,body,filenamePDF,filenameExcel);
		transportMail();
	}
	private void transportMail() throws MessagingException {
		String fromUser="iamvjakash@gmail.com";
		String fromUserPassword="rlytlfnamxtcmnef";
		String emailHost="smtp.gmail.com";
		Transport transport=newSession.getTransport("smtp");
		transport.connect(emailHost, fromUser, fromUserPassword);
		transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
		transport.close();
//		Transport.send(mimeMessage);   
		System.out.println("Email sent successfully.....");
		
		
	}

	private MimeMessage draftMail(String to[],String subject,String body,String filenamePDF,String filenameExcel) throws AddressException, MessagingException {
		String[] emailReceipients= to;
		String emailSubject=subject;
		String emailBody=body;
		
		mimeMessage=new MimeMessage(newSession);
		
		for(String receipient:emailReceipients) {
//			System.out.println(receipient);
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(receipient));
		}
		
		mimeMessage.setSubject(emailSubject);
		
		MimeBodyPart bodyPart=new MimeBodyPart();
		bodyPart.setContent(emailBody, "text/html");
		
		MimeMultipart multipart=new MimeMultipart();
		multipart.addBodyPart(bodyPart);
		
		if(filenamePDF!=null && !filenamePDF.equals("")) {
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
//		    String file = "SendAttachment.java";//change accordingly  
		    DataSource source = new FileDataSource(filenamePDF);  
		    messageBodyPart2.setDataHandler(new DataHandler(source));  
		    messageBodyPart2.setFileName("invoice.pdf");  
			multipart.addBodyPart(messageBodyPart2);
		}
		if(filenameExcel!=null && !filenameExcel.equals("")) {
			MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
//		    String file = "SendAttachment.java";//change accordingly  
		    DataSource source = new FileDataSource(filenameExcel);  
		    messageBodyPart2.setDataHandler(new DataHandler(source));  
		    messageBodyPart2.setFileName("inovice.xlsx");  
			multipart.addBodyPart(messageBodyPart2);
		}
		

		
		mimeMessage.setContent(multipart);
		
		return mimeMessage;
		
	}

	private void setupServerProperties() {
		Properties properties=System.getProperties();
		properties.put("mail.smtp.port","587");
		properties.put("mail.smtp.auth","true");
		properties.put("mail.smtp.starttls.enable","true");
		properties.put("mail.smtp.host", "smtp.gmail.com");    
		properties.put("mail.smtp.auth", "true");    
//		properties.put("mail.smtp.socketFactory.port", "465");    
//		properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");    
//		properties.put("mail.smtp.port", "465");    
//        properties.put("mail.smtp.ssl.enable", "true");

		newSession=Session.getDefaultInstance(properties);//,null
//		String fromUser="iamvjakash@gmail.com";
//		String fromUserPassword="rlytlfnamxtcmnef";
//		newSession=Session.getInstance(properties,    
//		           new javax.mail.Authenticator() {    
//			           protected PasswordAuthentication getPasswordAuthentication() {    
//			        	   return new PasswordAuthentication(fromUser, fromUserPassword);  
//			           }    
//		           });    
//		newSession.setDebug(true);
		
	}
}
