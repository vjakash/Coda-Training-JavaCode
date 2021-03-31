package day16;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendMail {
	Session newSession;MimeMessage mimeMessage;
	public static void main(String[] args) throws Exception {
		SendMail sm=new SendMail();
		sm.setupServerProperties();
		sm.draftMail();
		sm.sendMail();
	}

	private void sendMail() throws MessagingException {
//		String fromUser="vjbakash@gmail.com";
//		String fromUserPassword="02301119";
//		String emailHost="smtp.gmail.com";
//		Transport transport=newSession.getTransport("smtp");
//		transport.connect(emailHost, fromUser, fromUserPassword);
//		transport.sendMessage(mimeMessage, mimeMessage.getAllRecipients());
//		transport.close();
		Transport.send(mimeMessage);   
		System.out.println("Email sent successfully.....");
		
		
	}

	private MimeMessage draftMail() throws AddressException, MessagingException {
		String[] emailReceipients= {"iamvjakash@gmail.com"};
		String emailSubject="This is sample subject";
		String emailBody="This is a mail from my java program";
		mimeMessage=new MimeMessage(newSession);
		
		for(String receipient:emailReceipients) {
			mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(receipient));
		}
		
		mimeMessage.setSubject(emailSubject);
		
		MimeBodyPart bodyPart=new MimeBodyPart();
		bodyPart.setContent(emailBody, "html/text");
		
		MimeMultipart multipart=new MimeMultipart();
		multipart.addBodyPart(bodyPart);
		
		mimeMessage.setContent(multipart);
		return mimeMessage;
		
	}

	private void setupServerProperties() {
		Properties properties=System.getProperties();
		properties.put("mail.smtp.port","587");
		properties.put("mail.smtp.auth","true");
		properties.put("mail.smtp.starttls.enable","true");
		properties.put("mail.smtp.host", "smtp.gmail.com");    
//		properties.put("mail.smtp.host", host);
//		properties.put("mail.smtp.user", from);
//		properties.put("mail.smtp.password", pass);
//		properties.put("mail.smtp.socketFactory.port", "465");    
//		properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");    
		properties.put("mail.smtp.auth", "true");    
//		properties.put("mail.smtp.port", "465");    
//        properties.put("mail.smtp.ssl.enable", "true");

//		newSession=Session.getDefaultInstance(properties);//,null
		String fromUser="vjbakash@gmail.com";
		String fromUserPassword="02301119";
		newSession=Session.getInstance(properties,    
		           new javax.mail.Authenticator() {    
			           protected PasswordAuthentication getPasswordAuthentication() {    
			        	   return new PasswordAuthentication(fromUser, fromUserPassword);  
			           }    
		           });    
		newSession.setDebug(true);
		
	}
}
