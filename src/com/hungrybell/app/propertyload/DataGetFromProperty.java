package com.hungrybell.app.propertyload;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DataGetFromProperty {

	public String username;
	public String password;
	public  String sender;
	public  String url;
	public String emailidname;
	public String emailpassword;
	public String working_key;
	public String sender_id;
	public String api_url;
	public String  authorizationPayu;
	public String  payu_url;
	



	public String getPropValues() throws IOException {

		String result = "";
		Properties prop = new Properties();
		System.out.println("ho gaya...............kkk...3.....");
		//String propFileName = "com/hungrybell/resource/application.properties";
		
		String propFileName ="com/hungrybell/resource/application.properties";

		InputStream inputStream = getClass().getClassLoader()
				.getResourceAsStream(propFileName);

		if (inputStream != null) {
			prop.load(inputStream);
		} else {
			throw new FileNotFoundException("property file '" + propFileName
					+ "' not found in the classpath");
		}

		username = prop.getProperty("username");
		password = prop.getProperty("password");
		sender = prop.getProperty("sendername");
		url = prop.getProperty("url");
		emailidname = prop.getProperty("emailidname");
		emailpassword = prop.getProperty("emailpassword");
		
		working_key = prop.getProperty("working_key");
		sender_id = prop.getProperty("sender_id");
		api_url = prop.getProperty("api_url");
		
		authorizationPayu=prop.getProperty("authorizationPayu");
		payu_url=prop.getProperty("payu_url");
		

		return result;
	}

}
