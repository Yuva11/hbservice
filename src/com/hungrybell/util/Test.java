package com.hungrybell.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.hungrybell.app.model.OpinioPostOrder;

public class Test {
public static void main(String[] args) throws Exception{
	SortedMap<String, String> sortedParamMap =new TreeMap<String, String>();
	
	sortedParamMap.put("merchant_id","3");
	sortedParamMap.put("amount","250");
	sortedParamMap.put("amount_to_pay","250");
	sortedParamMap.put("phone","7411446750");
	sortedParamMap.put("address","Testing");
	sortedParamMap.put("locality","test");
	sortedParamMap.put("order_code","10");
	
	OpinioPostOrder opinioPostOrder=new OpinioPostOrder();
	opinioPostOrder.setMerchant_id("3");
	opinioPostOrder.setAmount(250);
	opinioPostOrder.setAmount_to_pay(250);
	opinioPostOrder.setPhone("7411446750");
	opinioPostOrder.setAddress("Testing");
	opinioPostOrder.setLocality("test");
	opinioPostOrder.setOrder_code("10");
	
	String canonicalString=canonicalize(sortedParamMap);
	String StringToSign ="POST" + "\n" +
			"test.deliver.opinioapp.com" + "\n" +
			"/api/v1/orders" + "\n" +
			"PJksl89uh7hsaMskd" + "\n" +
			canonicalString+ "\n" +
			"&SignatureVersion=1" + "\n" +
			"&SignatureMethod=HmacSHA1" ;
	System.out.println("StringToSign  "+StringToSign);
	//String signature=sha1(StringToSign, "ILasdi9809ck09icHN");//ILasdi9809ck09icHN
	String signature=calculateRFC2104HMAC(StringToSign, "ILasdi9809ck09icHN");
	System.out.println("signature----------"+signature);
	String Authorization ="Opinio" + " " + "PJksl89uh7hsaMskd" + ":" + signature;
	
	
	System.err.println("Authorization-----"+Authorization);

	
	// Posting Service
	RestTemplate restTemplate = new RestTemplate();
	/*List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
	acceptableMediaTypes.add("");*/
	HttpHeaders headers = new HttpHeaders();
	headers.add("Content-Type", "application/x-www-form-urlencoded");
	headers.add("Authorization",Authorization);
	
	HttpEntity<String> entity = new HttpEntity<String>("http://test.deliver.opinioapp.com/api/v1/orders", headers);
	try {
		ResponseEntity<OpinioPostOrder> result = restTemplate.exchange("http://test.deliver.opinioapp.com/api/v1/orders", HttpMethod.POST, entity, OpinioPostOrder.class);
		System.err.println(result.getBody());
	} catch (Exception e) {
		e.printStackTrace();
	}

	
}

	public static String sha1(String messsage, String keyString)throws  Exception{

		Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
	    SecretKeySpec secret_key = new SecretKeySpec(keyString.getBytes(), "HmacSHA1");
	    sha256_HMAC.init(secret_key);

	    String hash = Base64.getEncoder().encodeToString(sha256_HMAC.doFinal(messsage.getBytes()));
	    System.out.println(hash);
	    return hash;
		/*SecretKeySpec key = new SecretKeySpec((keyString).getBytes("UTF-8"),"HmacSHA1");
		Mac mac = Mac.getInstance("HmacSHA1");
		mac.init(key);
		byte[] bytes = mac.doFinal(messsage.getBytes("UTF-8"));
		return Base64.getEncoder().encodeToString(bytes);*/
	}
	
	
	private static String canonicalize(SortedMap<String, String> sortedParamMap)
	{
	    if (sortedParamMap.isEmpty()) {
	      return "";
	    }

	    StringBuffer buffer = new StringBuffer();
	    Iterator<Map.Entry<String, String>> iter =
	      sortedParamMap.entrySet().iterator();

	    while (iter.hasNext()) {
	    	
	      Map.Entry<String, String> kvpair = iter.next();
		  buffer.append("&");
	      buffer.append(percentEncodeRfc3986(kvpair.getKey()));
	      buffer.append("=");
	      buffer.append(percentEncodeRfc3986(kvpair.getValue()));
	     
	    }
	    System.out.println(buffer);
	    String canonical = buffer.toString();
	    return canonical;
	  }

	public static  String percentEncodeRfc3986(String s) {
		String out;
		try {
			out = URLEncoder.encode(s, "UTF-8").replace("+", "%20")
					.replace("*", "%2A").replace("%7E", "~");
		} catch (UnsupportedEncodingException e) {
			out = s;
		}
		return out;
	}
	public static String calculateRFC2104HMAC(String data, String key)
			throws java.security.SignatureException
			{
			String result;
			try {

			// get an hmac_sha1 key from the raw key bytes
			SecretKeySpec signingKey = new SecretKeySpec(key.getBytes(), "HmacSHA1");

			// get an hmac_sha1 Mac instance and initialize with the signing key
			Mac mac = Mac.getInstance("HmacSHA1");
			mac.init(signingKey);

			// compute the hmac on input data bytes
			byte[] rawHmac = mac.doFinal(data.getBytes());

			// base64-encode the hmac
			byte[] encodedBytes = Base64.getEncoder().encode(rawHmac);
			System.out.println("ecncoded value is " + new String(encodedBytes ));
			result=new String(encodedBytes );
			} catch (Exception e) {
			throw new SignatureException("Failed to generate HMAC : " + e.getMessage());
			}
			return result;
}
}