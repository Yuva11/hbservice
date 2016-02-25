package com.hungrybell.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.hungrybell.app.model.NewPayment;
import com.hungrybell.app.propertyload.DataGetFromProperty;
import com.hungrybell.app.service.DynamicDataService;
import com.hungrybell.app.vo.request.AddToCartRequestVO;
import com.hungrybell.app.vo.response.GetResponsePayuVO;

@Controller
public class GetResponseFromPAYUController {
	@Autowired
	DynamicDataService dynamicDataService;
	@RequestMapping(value = "/getResponseFromPayu.do", method = RequestMethod.POST)
	@Scheduled(fixedDelay = 3600000)
	public void postPayUMoney() 
	 {	// Read list from DB
		String iniciatedPayuResponse=null;
		List<String> paymentId=dynamicDataService.getNewPayDetails();
		List<String> orderId=dynamicDataService.getNewOrderDetails();
		String merchantTransactionIds="";
		
		for (String string : paymentId) {
			System.out.println("Size:paymentId:"+string+"|");
		}
		
		for (String string : orderId) {
			System.out.print("Size:orderId:"+string+"|");
		}
	    if(paymentId!=null)
		{	
	 	for(int i=0;i<paymentId.size();i++)
		{
	 		String temp=paymentId.get(i);
	 		boolean exists=false;
	 		for(int j=0;j<orderId.size();j++)
	 		{
	 			if(orderId.get(j).equals(temp)){
	 				exists=true;
	 				break;
	 			}
	 		}
	 		if(!exists)
	 			merchantTransactionIds+=paymentId.get(i)+"|";
	 			
	 		System.out.println(merchantTransactionIds);
	 }
	  

	    String authorizationPayu=null;
	    String payu_url=null;
	    DataGetFromProperty dataGetFromProperty=new DataGetFromProperty();
	    try
	    {
	       dataGetFromProperty.getPropValues();
	       authorizationPayu=dataGetFromProperty.authorizationPayu;
	       payu_url=dataGetFromProperty.payu_url;
	    }
	    catch(Exception ek)
	    {
	  //  	ek.printStackTrace();
	    }
	    
	    
		String url=payu_url+merchantTransactionIds;
		RestTemplate restTemplate = new RestTemplate();
		// Prepare acceptable media type
		System.out.println(url);
		List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
		acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
		// Prepare header
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(acceptableMediaTypes);
		headers.add("Authorization",authorizationPayu);
		// Pass the new person and header
		HttpEntity<String> entity = new HttpEntity<String>(url, headers);
        // Send the request as POST
		try {
			@SuppressWarnings("unused")
			ResponseEntity<GetResponsePayuVO> result = restTemplate.exchange(url, HttpMethod.POST, entity, GetResponsePayuVO.class);
			Gson gson = new Gson();
        	// convert java object to JSON format,
			// and returned as JSON formatted string
			iniciatedPayuResponse = gson.toJson(result.getBody().getResult());
			dynamicDataService.updateIniciatedDataOfPayu(result.getBody().getResult());
			

		} catch (Exception e) {
	//		e.printStackTrace();
		}
		
	}
	   // return iniciatedPayuResponse;

	 }
}
