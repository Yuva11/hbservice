<%@page import="com.hungrybell.app.model.DealOrders"%>
<%@page import="com.hungrybell.app.controller.Team_Sms_Email_Controller"%>
<%@page import="javassist.bytecode.stackmap.BasicBlock.Catch"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*"%>
<%@page import="java.text.*"%>
<%@page import="java.sql.ResultSet"%>

<%@page import="java.sql.*"%>
<%@page import="java.util.Date"%>
<%@include file="getcon.jsp"%>
<jsp:useBean id="smsemail"
	class="com.hungrybell.app.controller.Team_Sms_Email_Controller"></jsp:useBean>


<!doctype html>
<html class="no-js">
<head>
<link rel="stylesheet" type="text/css" href="css/style3.css" />
<link rel="stylesheet" href="css/style34.css" media="all">
<link rel="stylesheet" href="css/styles.css">


<meta charset="utf-8">

<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

<title>Hungry Bells Payment Status</title>

<meta http-equiv="cleartype" content="on">

<link rel="shortcut icon" href="/favicon.ico">

<!-- Responsive and mobile friendly stuff -->
<meta name="HandheldFriendly" content="True">
<meta name="MobileOptimized" content="320">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style type="text/css">
#maincontent .col {
	background: #ccc;
	background: rgba(204, 204, 204, 0.85);
}
</style>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
<script src="js/jquery-1.9.1.js"></script>
<script src="js/jquery-ui.js"></script>


</head>

<body onload="window.close();">
	<%
	
		PreparedStatement ps = null;
		ResultSet rs = null;
		PreparedStatement ps1 = null;
		ResultSet rs1 = null;
		PreparedStatement ps2 = null;
		ResultSet rs2 = null;
		PreparedStatement ps3 = null;
		ResultSet rs3 = null;
		
		PreparedStatement ps4 = null;
		ResultSet rs4 = null;
		
		PreparedStatement ps5 = null;
		ResultSet rs5 = null;
		
		PreparedStatement ps6 = null;
		ResultSet rs6 = null;
		
		long c = 0;
		Timestamp ts = new Timestamp(System.currentTimeMillis());

		String mihpayid = (String) request.getParameter("mihpayid");
		String mode = request.getParameter("mode");
		String status = request.getParameter("status");
		String key = request.getParameter("key");
		String txnid =request.getParameter("txnid"); 
		String amount = request.getParameter("amount");
		String discount = request.getParameter("discount");
		String productinfo = request.getParameter("productinfo");
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String city = request.getParameter("city");

		String state = request.getParameter("state");
		String country = request.getParameter("country");
		String zipcode = request.getParameter("zipcode");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String udf1 = request.getParameter("udf1");
		String udf2 = request.getParameter("udf2");
		String udf3 = request.getParameter("udf3");
		String udf4 = request.getParameter("udf4");
		String udf5 = request.getParameter("udf5");
		String hash = request.getParameter("hash");
		String Error = request.getParameter("Error");
		String PG_TYPE = request.getParameter("PG_TYPE");
		String bank_ref_num = request.getParameter("bank_ref_num");
		String shipping_firstname = request
				.getParameter("shipping_firstname");
		String shipping_lastname = request
				.getParameter("shipping_lastname");
		String shipping_address1 = request
				.getParameter("shipping_address1");
		String shipping_address2 = request
				.getParameter("shipping_address2");
		String shipping_city = request.getParameter("shipping_city");
		String shipping_state = request.getParameter("shipping_state");
		String shipping_country = request.getParameter("shipping_country");
		String shipping_zipcode = request.getParameter("shipping_zipcode");
		String shipping_phone = request.getParameter("shipping_phone");
		String shipping_phoneverified = request
				.getParameter("shipping_phoneverified");
		String unmappedstatus = request.getParameter("unmappedstatus");
		String payuMoneyId = request.getParameter("payuMoneyId");

		System.out.println("----1---" + txnid);

		try {
			if (payuMoneyId != null) {
				ps = con.prepareStatement("insert into newpayment values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				ps.setLong(1, c);
				ps.setString(2, mihpayid);
				ps.setString(3, mode);
				ps.setString(4, status);
				ps.setString(5, key);
				ps.setString(6, txnid);
				ps.setString(7, amount);
				ps.setString(8, discount);
				ps.setString(9, productinfo);
				ps.setString(10, firstname);
				ps.setString(11, lastname);
				ps.setString(12, address1);
				ps.setString(13, address2);
				ps.setString(14, city);
				ps.setString(15, state);
				ps.setString(16, country);
				ps.setString(17, zipcode);
				ps.setString(18, email);
				ps.setString(19, phone);
				ps.setString(20, udf1);
				ps.setString(21, udf2);
				ps.setString(22, udf3);
				ps.setString(23, udf4);
				ps.setString(24, udf5);
				ps.setString(25, hash);
				ps.setString(26, Error);
				ps.setString(27, PG_TYPE);
				ps.setString(28, bank_ref_num);
				ps.setString(29, shipping_firstname);
				ps.setString(30, shipping_lastname);
				ps.setString(31, shipping_address1);
				ps.setString(32, shipping_address2);
				ps.setString(33, shipping_city);
				ps.setString(34, shipping_state);
				ps.setString(35, shipping_country);
				ps.setString(36, shipping_zipcode);
				ps.setString(37, shipping_phone);
				ps.setString(38, shipping_phoneverified);
				ps.setString(39, unmappedstatus);
				ps.setString(40, payuMoneyId);
				ps.setString(41, "" + ts);

				ps.executeUpdate();
			}

			/* 		response.sendRedirect("http://localhost:8090/HBAppService/paymentResponseForApp.do");
								
			 */
		} catch (Exception e) {
			System.out.print(e);
		}
		ArrayList orderlistDeal=new ArrayList();
		ArrayList orderlistDealQuantity=new ArrayList();
		try
		{
			System.out.println("---userid---");

			ps4 = con.prepareStatement("SELECT  * FROM orders where order_id=?");
			ps4.setString(1, txnid);

			rs4 = ps4.executeQuery();
			while(rs4.next())
			{
				orderlistDeal.add(rs4.getString(6));
				orderlistDealQuantity.add(rs4.getString(4));
			}
		}catch(Exception e)
		{
			
		}
		
		
		//------process our team sms email  startted-----------------

		if (txnid != null && status.equals("success") ) 
		{
			Team_Sms_Email_Controller team_Sms_Email_Controller = new Team_Sms_Email_Controller();

			try {
				System.out.println("---userid---");

				ps = con.prepareStatement("SELECT  * FROM neworderdetails where order_id=?");
				ps.setString(1, txnid);

				rs = ps.executeQuery();
				if (rs.next()) {
					System.out.println("---userid----"
							+ rs.getString("user_id"));

					try {
						ps1 = con
								.prepareStatement("SELECT  * FROM user where id=?");
						ps1.setString(1, rs.getString("user_id"));

						rs1 = ps1.executeQuery();
						if (rs1.next()) {

							try {
								ps2 = con
										.prepareStatement("SELECT  * FROM merchantbranch where id=?");
								ps2.setString(1,
										rs.getString("merchantbranch_id"));

								rs2 = ps2.executeQuery();
								if (rs2.next()) {
									System.out
											.println("---userid----"
													+ rs.getString("merchantbranch_id"));

									try {
										ps3 = con
												.prepareStatement("SELECT  * FROM deal where id=?");
										ps3.setString(1,
												rs.getString("deal_id"));

										rs3 = ps3.executeQuery();
										if (rs3.next()) 
										{
											long role_id=0;
											String user_email=null;
											String user_mobno=null;

											try {
												ps5 = con.prepareStatement("SELECT  * FROM roles where rolename=?");
												ps5.setString(1,"Operations Management");
												rs5 = ps5.executeQuery();
												if (rs5.next()) 
												{
													role_id=rs5.getLong(1);
													try {
														ps6 = con.prepareStatement("SELECT  * FROM user where role_id=?");
														ps6.setLong(1,role_id);
														rs6 = ps6.executeQuery();
														while (rs6.next()) 
														{
															user_email=rs6.getString("username");
															user_mobno=rs6.getString("contact_number");
							 					            team_Sms_Email_Controller.sendTeamSmsEmail(
										                                txnid,
																		rs1.getString("name"),
																		rs.getString("delivery_address"),
																		rs1.getString("contact_number"),
																		""+ rs.getString("order_quantity"),
																		""+ rs.getString("order_amount"),
																		rs2.getString("branch_name"),
																		rs3.getString("name"),
																		rs.getString("order_type"),
																		user_email,
																		user_mobno,null,null,null,null);
						 								}
														}catch(Exception ek)
													{
															
													}
												}
												}catch(Exception ek)
											{
													
											}
     //sms email going for customer      
					            team_Sms_Email_Controller.sendTeamSmsEmail(
				                                txnid,
												rs1.getString("name"),
												rs.getString("delivery_address"),
												rs1.getString("contact_number"),
												""+ rs.getString("order_quantity"),
												""+ rs.getString("order_amount"),
												rs2.getString("branch_name"),
												rs3.getString("name"),
												rs.getString("order_type"),null,null,rs1.getString("contact_number"),rs1.getString("email"),orderlistDeal,orderlistDealQuantity);
					            
					            
										}
									} catch (Exception e) {
										e.printStackTrace();

									}

								}
							} catch (Exception e) {

							}

						}
					} catch (Exception e) {

					}

				}
			} catch (Exception e) {

			}

		}
		//------process our team sms email finished-----------------

		//------process for Payment Reconciled-------------------

/* 		
		PreparedStatement ps4 = null;
		ResultSet rs4 = null;
		PreparedStatement ps5 = null;
		ResultSet rs5 = null;
		PreparedStatement ps6 = null;
		ResultSet rs6 = null;
		
		String merchantbranch_id=null;
		String merchant_id=null;
		try 
		{
			ps4 = con.prepareStatement("SELECT  * FROM neworderdetails where order_id=?");
			ps4.setString(1,txnid);
			rs4 = ps4.executeQuery();
			if (rs4.next()) 
			{
				merchantbranch_id=rs4.getString("merchantbranch_id");
				
				try 
				{
					ps5 = con.prepareStatement("SELECT  * FROM merchantbranch where id=?");
					ps5.setString(1,merchantbranch_id);
					rs5 = ps5.executeQuery();
					if (rs5.next()) 
					{
						merchant_id=rs5.getString("merchant_id");
						
						try 
						{
							ps6 = con.prepareStatement("SELECT  * FROM newpayment where txnid=?");
							ps6.setString(1,txnid);
							rs6 = ps6.executeQuery();
							if (rs6.next()) 
							{
								status1=rs6.getString("status");
								amount1=rs6.getString("amount");
								status1=rs6.getString("status");
								status1=rs6.getString("status");
								
									
							}
						}
						catch(Exception ek)
						{
							
						}
						
						
							
					}
				}
				catch(Exception ek)
				{
					
				}
				
					
			}
		}
		catch(Exception ek)
		{
			
		}
		
 */		
		
		
		//------process for Payment Reconciled-------------------
		
		con.close();

 %>


	Payment Status :
	<%=status%>

	<%
		System.out.println("---2----" + txnid);
		if (status.equals("success")) {

			response.sendRedirect("https://www.payumoney.com/mobileapp/payumoney/success.php");
		}
		if (status.equals("failure")) {
			response.sendRedirect("https://www.payumoney.com/mobileapp/payumoney/failure.php");
		}

		if (status.equals("pending")) {

			response.sendRedirect("https://www.payumoney.com/mobileapp/payumoney/failure.php");
		}
	%>



	</table>













	</div>














	</div>

	</div>





	</div>
	</div>

	</div>







</body>
</html>