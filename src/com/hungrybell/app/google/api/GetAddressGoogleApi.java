package com.hungrybell.app.google.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONArray;

import com.google.gson.Gson;

public class GetAddressGoogleApi 
{
	
	 public  String getAddress(String user_lat,String user_long,String merchant_lat,String merchant_long) 
	 {
		 String  outputString = "";
		  // Reference - https://developers.google.com/maps/documentation/distancematrix/
		 try
		 {
		 Gson gson = new Gson();
		 
			 
		String url1="https://maps.googleapis.com/maps/api/distancematrix/json?origins="+user_lat+","+user_long+"&destinations="+merchant_lat+","+merchant_long+"&sensor=false&key=AIzaSyBXHMNB2AdpIk6OXodKU3W0l74Nk8sE3h8".trim();
		
		System.out.println("kk- "+url1);
		URL url = new URL(url1);
		  HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	      conn.setRequestMethod("GET");
	      String line;
	      BufferedReader reader = new BufferedReader( new InputStreamReader(conn.getInputStream()));
	      while ((line = reader.readLine()) != null)
	      {
	          outputString += line;
	      }
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
			 
		 }
		 
		 return outputString;
	   }
	
	
	 public static void main(String ar[])
	 {
		 GetAddressGoogleApi getAddressGoogleApi=new GetAddressGoogleApi();
		 
		 try
		 {
		 
		 System.out.println(getAddressGoogleApi.getAddress("12.890907","77.640089", "12.925543","77.675966"));
		 }
		 catch(Exception ek)
		 {
			 ek.printStackTrace();
		 }
	 }
	 

}
