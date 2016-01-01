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

public class EmailUtility extends HttpServlet {
	static Properties props = new Properties();

	DataGetFromProperty dataGetFromProperty = new DataGetFromProperty();

	public String emailSend(String emailid, String orderiid, String name,
			String address, String mobno, Long order_quantity,
			Double Order_amount, String merchnatname, String dealname,
			String order_type) {
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
			msg.setSubject("Order Received");
			msg.setContent(
					"<html><h6><font color=\"black\" size='2' style="
							+ "background-color:yellow"
							+ ">Dear "
							+ "Hungry Bells Team,"
							+ "<br><br>New Order Received</font><br></h6>"
							+ "<font color=\"black\" size='2' style="
							+ "background-color:yellow"
							+ "><b>Order reference no:</b>  </font><font color=\"black\" size='2' style="
							+ "background-color:yellow" + ">"
							+ orderiid
							+ "</font><br><br>"
							+ "<font color=\"black\" size='2' style="
							+ "background-color:yellow"
							+ "><b>Customer Name: </b></font> <font color=\"black\" size='2' style="
							+ "background-color:yellow"
							+ ">"
							+ name
							+ "</font><br><br>"
							+ "<font color=\"black\" size='2' style="
							+ "background-color:yellow"
							+ "><b>Mob No.: </b> </font> <font color=\"black\" size='2' style="
							+ "background-color:yellow"
							+ ">"
							+ mobno
							+ "</font><br><br>"
							+ "<font color=\"black\" size='2' style="
							+ "background-color:yellow"
							+ "><b>Order Quantity : </b> </font> <font color=\"black\" size='2' style="
							+ "background-color:yellow"
							+ ">"
							+ order_quantity
							+ "</font><br><br>"
							+ "<font color=\"black\" size='2' style="
							+ "background-color:yellow"
							+ "><b>Merchant Name: </b> </font> <font color=\"black\" size='2' style="
							+ "background-color:yellow"
							+ ">"
							+ merchnatname

							+ "</font><br><br>"
							+ "<font color=\"black\" size='2' style="
							+ "background-color:yellow"
							+ "><b>Deal Name: </b></font> <font color=\"black\" size='2' style="
							+ "background-color:yellow"
							+ ">"
							+ dealname

							+ "</font><br><br>"
							+ "<font color=\"black\" size='2' style="
							+ "background-color:yellow"
							+ "><b>Total Amount :</b> </font> <font color=\"black\" size='2' style="
							+ "background-color:yellow"
							+ ">"
							+ Order_amount

							+ "</font><br><br>"
							+ "<font color=\"black\" size='2' style="
							+ "background-color:yellow"
							+ "><b>Delivery Type:</b> </font> <font color=\"black\" size='2' style="
							+ "background-color:yellow"
							+ ">"
							+ order_type

							+ "</font><br><br>"
							+ "<font color=\"black\" size='2' style="
							+ "background-color:yellow"
							+ "><b>Delivery Address : </b></font> <font color=\"black\" size='2' style="
							+ "background-color:yellow"
							+ ">"
							+ address

							+ "</font><br><br>"
							+ "<font color=\"black\" size='2' style="
							+ "background-color:yellow"
							+ "><b>-----------------------------------------------------------------------------------------------------<br>For any further assistance please reach out to the Hungry Bells Team</b><br>Thank You,<br>Hungry Bells Operations Team<br>Tel:+91 80 8800 2288<br>Email: hungrybells@getwise.in :- </font> <font color=\"black\" size='2' style="
							+ "background-color:yellow" + ">"

							+ "</html>", "text/html");

			InternetAddress from = new InternetAddress(
					dataGetFromProperty.emailidname, "Hungry Bells");
			InternetAddress to = new InternetAddress(emailid, "Mr. "
					+ name.toUpperCase());
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
	//////////////////////////////////////////////////////////////
	
	
	public String emailSendAddToCart(String emailid, String orderiid, String name,
			String address, String mobno, String order_quantity,
			String Order_amount, String merchnatname, String dealname,
			String order_type) {
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
			msg.setSubject("Order Received");
			msg.setContent(
					"<html><h6><font color=\"black\" size='2' style="
							+ "background-color:yellow"
							+ ">Dear "
							+ "Hungry Bells Team,"
							+ "<br><br>New Order Received</font><br></h6>"
							+ "<font color=\"black\" size='2' style="
							+ "background-color:yellow"
							+ "><b>Order reference no:</b>  </font><font color=\"black\" size='2' style="
							+ "background-color:yellow" + ">"
							+ orderiid
							+ "</font><br><br>"
							+ "<font color=\"black\" size='2' style="
							+ "background-color:yellow"
							+ "><b>Customer Name: </b></font> <font color=\"black\" size='2' style="
							+ "background-color:yellow"
							+ ">"
							+ name
							+ "</font><br><br>"
							+ "<font color=\"black\" size='2' style="
							+ "background-color:yellow"
							+ "><b>Mob No.: </b> </font> <font color=\"black\" size='2' style="
							+ "background-color:yellow"
							+ ">"
							+ mobno
							+ "</font><br><br>"
							+ "<font color=\"black\" size='2' style="
							+ "background-color:yellow"
							+ "><b>Order Quantity : </b> </font> <font color=\"black\" size='2' style="
							+ "background-color:yellow"
							+ ">"
							+ order_quantity
							+ "</font><br><br>"
							+ "<font color=\"black\" size='2' style="
							+ "background-color:yellow"
							+ "><b>Merchant Name: </b> </font> <font color=\"black\" size='2' style="
							+ "background-color:yellow"
							+ ">"
							+ merchnatname

							+ "</font><br><br>"
							+ "<font color=\"black\" size='2' style="
							+ "background-color:yellow"
							+ "><b>Deal Name: </b></font> <font color=\"black\" size='2' style="
							+ "background-color:yellow"
							+ ">"
							+ dealname

							+ "</font><br><br>"
							+ "<font color=\"black\" size='2' style="
							+ "background-color:yellow"
							+ "><b>Total Amount :</b> </font> <font color=\"black\" size='2' style="
							+ "background-color:yellow"
							+ ">"
							+ Order_amount

							+ "</font><br><br>"
							+ "<font color=\"black\" size='2' style="
							+ "background-color:yellow"
							+ "><b>Delivery Type:</b> </font> <font color=\"black\" size='2' style="
							+ "background-color:yellow"
							+ ">"
							+ order_type

							+ "</font><br><br>"
							+ "<font color=\"black\" size='2' style="
							+ "background-color:yellow"
							+ "><b>Delivery Address : </b></font> <font color=\"black\" size='2' style="
							+ "background-color:yellow"
							+ ">"
							+ address

							+ "</font><br><br>"
							+ "<font color=\"black\" size='2' style="
							+ "background-color:yellow"
							+ "><b>-----------------------------------------------------------------------------------------------------<br>For any further assistance please reach out to the Hungry Bells Team</b><br>Thank You,<br>Hungry Bells Operations Team<br>Tel:+91 80 8800 2288<br>Email: hungrybells@getwise.in :- </font> <font color=\"black\" size='2' style="
							+ "background-color:yellow" + ">"

							+ "</html>", "text/html");

			InternetAddress from = new InternetAddress(
					dataGetFromProperty.emailidname, "Hungry Bells");
			InternetAddress to = new InternetAddress(emailid, "Mr. "
					+ name.toUpperCase());
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
	
	
	////////////email method for trending and recomended proceesing
	
	public String emailSendOurTeamForTrendingRecom(String emailid) {
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
			msg.setSubject("Scheduler For Tags");
			msg.setContent(
					"<html><h4><font color=\"black\" size='2' style="
							+ "background-color:white"
							+ ">Dear "
							+ "Hungry Bells Team,"
							+ "<br><br>Trending and recommended  tags successfully updated.</font><br></h4>"
							+ "<font color=\"black\" size='2' style="
							+ "background-color:white"
							+ "</html>", "text/html");

			InternetAddress from = new InternetAddress(
					dataGetFromProperty.emailidname, "Hungry Bells");
			InternetAddress to = new InternetAddress(emailid, "Mr. HungryBells Team");
			msg.addRecipient(Message.RecipientType.TO, to);
			msg.setFrom(from);

			Transport transport = session.getTransport("smtp");
			transport.connect(dataGetFromProperty.emailidname,dataGetFromProperty.emailpassword);
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			System.out.println("!! Email Triggered !!");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "seccess";
	}
	
	
	
	

}
