package com.hungrybell.app.email;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServlet;

import com.hungrybell.app.propertyload.DataGetFromProperty;

public class EmailCheckUtility extends HttpServlet {
	static Properties props = new Properties();
	DataGetFromProperty dataGetFromProperty = new DataGetFromProperty();
	public String emailSend(String emailid) {
		try {
			dataGetFromProperty.getPropValues();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
			Session session = Session.getInstance(props,
					new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(
									dataGetFromProperty.emailidname,
									dataGetFromProperty.emailpassword);
						}
					});
			Message msg = new MimeMessage(session);
			msg.setSubject("Order Received");
			msg.setContent(
					"<html><h6><font color=\"black\" size='2' style="
							+ "background-color:yellow" + ">"
							+ "</html>", "text/html");

			InternetAddress from = new InternetAddress(
					dataGetFromProperty.emailidname, "Hungry Bells");
			InternetAddress to = new InternetAddress(emailid, "Mr. Bheem Singh");
			msg.addRecipient(Message.RecipientType.TO, to);
			msg.setFrom(from);

			Transport transport = session.getTransport("smtp");
			transport.connect(dataGetFromProperty.emailidname,	dataGetFromProperty.emailpassword);
			transport.sendMessage(msg, msg.getAllRecipients());
			
			transport.close();

			return "success";
			
		} catch (Exception e) {
			return "failure";
		}
//		return "failure";
	}
	//////////////////////////////////////////////////////////////

	public static void main(String ar[])
	{
		EmailCheckUtility emailCheckUtility=new EmailCheckUtility();
		String emailValidOrNot=emailCheckUtility.emailSend("bheemhfghfghcvbvvcv@getwise.in");
		if(emailValidOrNot.equals("success"))
		{
			System.out.println("success");
		}
		else {
			System.out.println("failure");
			
		}
		
	}
	
}
