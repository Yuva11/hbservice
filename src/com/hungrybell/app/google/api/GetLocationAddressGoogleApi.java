
package com.hungrybell.app.google.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONArray;

import com.google.gson.Gson;

public class GetLocationAddressGoogleApi 
{
	
	 public  String getLocationAddress(String latitude,String longitudde) 
	 {
		 String  outputString = "";
		  // Reference - https://developers.google.com/maps/documentation/distancematrix/
		 try
		 {
		 Gson gson = new Gson();
		String url1="https://maps.googleapis.com/maps/api/geocode/json?latlng="+latitude+","+longitudde+"&sensor=false&key=AIzaSyBXHMNB2AdpIk6OXodKU3W0l74Nk8sE3h8".trim();
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
	
	 
	 
	 public  String getCityName(String latitude,String longitudde) 
	 {
		 String  outputString = "";
		  // Reference - https://developers.google.com/maps/documentation/distancematrix/
		 try
		 {
		 Gson gson = new Gson();
		String url1="https://maps.googleapis.com/maps/api/geocode/json?latlng="+latitude+","+longitudde+"&sensor=false&key=AIzaSyBXHMNB2AdpIk6OXodKU3W0l74Nk8sE3h8".trim();
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
		 GetLocationAddressGoogleApi getAddressGoogleApi=new GetLocationAddressGoogleApi();
		 try
		 {
		 System.out.println(getAddressGoogleApi.getLocationAddress("12.9095681","77.6063823"));
		 }
		 catch(Exception ek)
		 {
			 ek.printStackTrace();
		 }
	 }
	 

}
