
package com.hungrybell.app.email;

import java.io.PrintWriter;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hungrybell.app.propertyload.DataGetFromProperty;

public class EmailUtilityForAdmin extends HttpServlet {
	static Properties props = new Properties();

	DataGetFromProperty dataGetFromProperty = new DataGetFromProperty();

	public String emailSendForAdmin(String emailid, String conform_pass) {
		try {
			dataGetFromProperty.getPropValues();
			System.out.println("Email Triggering Please Wait.......");
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
			msg.setSubject("Password Reset");
			msg.setContent(
					"<html><h6><font color=\"black\" size='1' style="
							+ "background-color:white"
							+ ">Dear "
							+ "Hungry Bells User,"
							+ "</font><br><br>Your password is - "+conform_pass+"<br><br>"
							+ "<font color=\"black\" size='1' style="
							+ "background-color:white"
							+ "><b><br>For any further assistance please reach out to the Hungry Bells Team</b><br>Thank You,<br>Hungry Bells IT Admin<br>Tel:+91 80 8800 2288<br>Email: hungrybells@getwise.in :- </font> <font color=\"black\" size='2' style="
							+ "background-color:white" + ">"

							+ "</html>", "text/html");

			InternetAddress from = new InternetAddress(
					dataGetFromProperty.emailidname, "Hungry Bells");
			InternetAddress to = new InternetAddress(emailid, "Mr. "
					+ emailid.toUpperCase());
			msg.addRecipient(Message.RecipientType.TO, to);
			msg.setFrom(from);

			Transport transport = session.getTransport("smtp");
			transport.connect(dataGetFromProperty.emailidname,
					dataGetFromProperty.emailpassword);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			System.out.println("!! Email Triggered !!");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "seccess";
	}
	

}
