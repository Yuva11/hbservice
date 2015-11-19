package com.hungrybell.app.sms;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.hungrybell.app.date.GetDateFromSystem;
import com.hungrybell.app.propertyload.DataGetFromProperty;

public class SmsUtility {

	public String smsSend(String orderidcreate, Long order_quantity,
			String merchantname, String mobile_numberteam, String dealname,
			String order_type, String first_name,String cust_mobile_no) {
		try {
			Map<String, String> uriVar = new HashMap<String, String>();

			DataGetFromProperty dataGetFromProperty = new DataGetFromProperty();
			GetDateFromSystem getDateFromSystem = new GetDateFromSystem();

			dataGetFromProperty.getPropValues();
			uriVar.put("username", dataGetFromProperty.username);
			uriVar.put("password", dataGetFromProperty.password);
			uriVar.put("sendername", dataGetFromProperty.sender);
			String orderdate = "" + getDateFromSystem.getDateFromSystem();

			String temp2 = null, temp3 = null;
			int count2 = 0;
		    String temp33=merchantname;
			if(merchantname.length()>12)
			{
			     temp33 = merchantname.substring(0,12 );
			}
					
			String orderdate1 = orderdate.substring(0, 16);

			String messagemb ="Dear Team Customer Order "+orderidcreate+" dated "+orderdate1+" Qty "+order_quantity+" to "+temp33+" has been placed by "+first_name+" mobileno "+cust_mobile_no;
			
			uriVar.put("message", messagemb);
			uriVar.put("mobileno", mobile_numberteam);

			RestTemplate rt = new RestTemplate();
			ResponseEntity<String> response = rt.exchange(
					dataGetFromProperty.url, HttpMethod.GET, null,
					String.class, uriVar);

		} catch (Exception e) {

		}
		return "success";
	}

	
	
	public String smsSendAddToCart(String orderidcreate, String order_quantity,
			String merchantname, String mobile_numberteam, String dealname,
			String order_type, String first_name,String cust_mobile_no) {
		try {
			Map<String, String> uriVar = new HashMap<String, String>();

			DataGetFromProperty dataGetFromProperty = new DataGetFromProperty();
			GetDateFromSystem getDateFromSystem = new GetDateFromSystem();
			System.out.println("magage send------4-----");

			dataGetFromProperty.getPropValues();
			uriVar.put("username", dataGetFromProperty.username);
			uriVar.put("password", dataGetFromProperty.password);
			uriVar.put("sendername", dataGetFromProperty.sender);
			String orderdate = "" + getDateFromSystem.getDateFromSystem();
			String temp2 = null, temp3 = null;
			int count2 = 0;
		    String temp33=merchantname;
			if(merchantname.length()>12)
			{
			     temp33 = merchantname.substring(0,12 );
			}
			String orderdate1 = orderdate.substring(0, 16);
			String messagemb ="Dear Team Customer Order "+orderidcreate+" dated "+orderdate1+" Qty "+order_quantity+" to "+temp33+" has been placed by "+first_name+" mobileno "+cust_mobile_no;
			uriVar.put("message", messagemb);
			uriVar.put("mobileno", mobile_numberteam);
			RestTemplate rt = new RestTemplate();
			ResponseEntity<String> response = rt.exchange(
					dataGetFromProperty.url, HttpMethod.GET, null,
					String.class, uriVar);

		} catch (Exception e) {

		}
		return "success";
	}

}
