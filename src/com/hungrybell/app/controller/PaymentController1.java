/*
package com.hungrybell.app.controller;

import java.io.IOException;

import com.hungrybell.app.vo.response.*;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hungrybell.app.model.Deal;
import com.hungrybell.app.service.DynamicDataService;
import com.hungrybell.app.vo.request.AddToCartRequestVO;
import com.hungrybell.app.vo.request.CustomerVO;
import com.hungrybell.app.vo.request.DealUserActionRequestVO;
import com.hungrybell.app.vo.request.HomePageRequestVO;
import com.hungrybell.app.vo.request.PayUmoneyBean;
import com.hungrybell.app.vo.request.SearchPagePageRequestVO;
import com.hungrybell.app.vo.request.SearchPagePageRequestVOACT;
import com.hungrybell.app.vo.response.TagDealsListResponseVO;

@Controller
public class PaymentController1 {

	@Autowired
	DynamicDataService dynamicDataService;

	@RequestMapping(value = "/payumoneyresponse.do", method = RequestMethod.POST)
	@ResponseBody
	public Status savePaymentStatus(@RequestBody String input) {

		Status status=new Status();
		PayUmoneyBean payment = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			payment = mapper.readValue(input,PayUmoneyBean.class);

		
			dynamicDataService.addPaymentStatus1(
					payment.getMihpayid(),
			        payment.getMode(),	
			        payment.getStatus(),
			        payment.getKey(),
			        payment.getTxnid(),
			        payment.getAmount(),
			        payment.getDiscount(),
			        payment.getProductinfo(),
			        payment.getFirstname(),
			        payment.getLastname(),
			        payment.getAddress1(),
			        payment.getAddress2(),
		            payment.getCity(),
		            payment.getState(),
		            payment.getCountry(),
		            payment.getZipcode(),
		            payment.getEmail(),
		            payment.getPhone(),
		            payment.getUdf1(),
		            payment.getUdf2(),
		            payment.getUdf3(),
		            payment.getUdf4(),
		            payment.getUdf5(),
		            payment.getHash(),
		            null,
		           null,
		            payment.getBank_ref_num(),
		            payment.getShipping_firstname(),
		            payment.getShipping_lastname(),
		            payment.getShipping_address1(),
		            payment.getShipping_address2(),
		            payment.getShipping_city(),
		            payment.getShipping_state(),
		            payment.getShipping_country(),
		            payment.getShipping_zipcode(),
		            payment.getShipping_phone(),
		            payment.getShipping_phoneverified(),
		            payment.getUnmappedstatus(),
		            payment.getPayuMoneyId()
					
					);

		
			return status;

		} catch (Exception ex) {
			ex.printStackTrace();
			status.setCode(0);
			status.setMessage("Order Placed not Successfully");
			status.setOrderid("");
			return status;
			
		
		}

	}

}
*/