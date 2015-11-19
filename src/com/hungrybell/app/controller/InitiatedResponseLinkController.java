
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
import org.springframework.web.bind.annotation.RequestBody;
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
import com.hungrybell.app.vo.response.GetRequestPayuOnClickVO;
import com.hungrybell.app.vo.response.GetResponsePayuVO;
import com.hungrybell.app.vo.response.Status;

@Controller
public class InitiatedResponseLinkController {
	@Autowired
	DynamicDataService dynamicDataService;
	
	@RequestMapping(value = "/getResponseFromPayuOnClick.do", method = RequestMethod.POST)
	@ResponseBody
	public void addToCartOrder(@RequestBody String input) {
    	String authorizationPayu=null;
		Status status = new Status();
		String iniciatedPayuResponse=null;
		String merchantTransactionIds="";

		GetRequestPayuOnClickVO addToCartRequestVO = null;
		ObjectMapper mapper = new ObjectMapper();
		try 
		{
			addToCartRequestVO = mapper.readValue(input,GetRequestPayuOnClickVO.class);
			System.out.println("---txnid--"+addToCartRequestVO.getTxnid());
			merchantTransactionIds=addToCartRequestVO.getTxnid();
	//		return status;
		} catch (Exception ex) 
		{
			ex.printStackTrace();
        }
		
		
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
	    	ek.printStackTrace();
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
			e.printStackTrace();
		}
	
	//	return status;
	
}

}
