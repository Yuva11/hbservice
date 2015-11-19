/*
package com.hungrybell.app.controller;

import java.io.IOException;

import com.hungrybell.app.vo.response.*;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.hungrybell.app.model.Deal;
import com.hungrybell.app.model.NewPayment;
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
public class PaymentController {

	@Autowired
	DynamicDataService dynamicDataService;

	@RequestMapping(value = "/payumoneyrequest.do", method = RequestMethod.POST)
	@ResponseBody
	public void addToCartOrder(@RequestBody String input) {

		AddToCartRequestVO addToCartRequestVO = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			addToCartRequestVO = mapper.readValue(input,
					AddToCartRequestVO.class);

			dynamicDataService.saveUser(addToCartRequestVO.getBody().getUser_id(),
					addToCartRequestVO.getBody().getFirst_name(),
					addToCartRequestVO.getBody().getEmail(), addToCartRequestVO
							.getBody().getMobile_number(), addToCartRequestVO
							.getBody().getAddress(), addToCartRequestVO
							.getBody().getUser_id());

			dynamicDataService.saveAddToCartOrderDetails(addToCartRequestVO
					.getBody().getLongitude(), addToCartRequestVO.getBody()
					.getLatitude(), addToCartRequestVO.getBody().getAddress(),
					addToCartRequestVO.getBody().getLandmark(),
					addToCartRequestVO.getBody().getOrder_type(),
					addToCartRequestVO.getBody().getOrders(),
					addToCartRequestVO.getBody().getOrder_amount(),
					addToCartRequestVO.getBody().getDelivery_status(),
					addToCartRequestVO.getBody().getStatus(),
					addToCartRequestVO.getBody().getUser_id(),
					addToCartRequestVO.getBody().getMobile_number(),
					addToCartRequestVO.getBody().getFirst_name(),
					addToCartRequestVO.getBody().getEmail(),
					addToCartRequestVO.getBody().getDiscount_method(),
					addToCartRequestVO.getBody().getDiscount_amount(),
					addToCartRequestVO.getBody().getCoupon_code()
					
					
					);

			

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
		
		@RequestMapping(value = "/payumoneyrequest.do", method = RequestMethod.POST)
		public void savePaymentStatus(@ModelAttribute("command") PayUmoneyBean payUmoneyVO,BindingResult result) 
		{
	//		NewPayment newpayment = prepareModel(payUmoneyVO);
			dynamicDataService.addPaymentStatus(payUmoneyVO);
		//	return new ModelAndView("redirect:/add.html");
		}

        private NewPayment prepareModel(PayUmoneyBean payUmoneyVO){
			NewPayment payment = new NewPayment();
			payment.setMihpayid(payUmoneyVO.getMihpayid());
	        payment.setMode(payUmoneyVO.getMode());	
	        payment.setStatus(payUmoneyVO.getStatus());
	        payment.setKey(payUmoneyVO.getKey());
	        payment.setTxnid(payUmoneyVO.getTxnid());
	        payment.setAmount(payUmoneyVO.getAmount());
	        payment.setDiscount(payUmoneyVO.getDiscount());
	        payment.setProductinfo(payUmoneyVO.getProductinfo());
	        payment.setFirstname(payUmoneyVO.getFirstname());
	        payment.setLastname(payUmoneyVO.getLastname());
	        payment.setAddress1(payUmoneyVO.getAddress1());
	        payment.setAddress2(payUmoneyVO.getAddress2());
            payment.setCity(payUmoneyVO.getCity());
            payment.setState(payUmoneyVO.getState());
            payment.setCountry(payUmoneyVO.getCountry());
            payment.setZipcode(payUmoneyVO.getZipcode());
            payment.setEmail(payUmoneyVO.getEmail());
            payment.setPhone(payUmoneyVO.getPhone());
            payment.setUdf1(payUmoneyVO.getUdf1());
            payment.setUdf2(payUmoneyVO.getUdf2());
            payment.setUdf3(payUmoneyVO.getUdf3());
            payment.setUdf4(payUmoneyVO.getUdf4());
            payment.setUdf5(payUmoneyVO.getUdf5());
            payment.setHash(payUmoneyVO.getHash());
            payment.setError(payUmoneyVO.getError());
            payment.setPG_TYPE(payUmoneyVO.getPG_TYPE());
            payment.setBank_ref_num(payUmoneyVO.getBank_ref_num());
            payment.setShipping_firstname(payUmoneyVO.getShipping_firstname());
            payment.setShipping_lastname(payUmoneyVO.getShipping_lastname());
            payment.setShipping_address1(payUmoneyVO.getShipping_address1());
            payment.setShipping_address2(payUmoneyVO.getShipping_address2());
            payment.setShipping_city(payUmoneyVO.getShipping_city());
            payment.setShipping_state(payUmoneyVO.getShipping_state());
            payment.setShipping_country(payUmoneyVO.getShipping_country());
            payment.setShipping_zipcode(payUmoneyVO.getShipping_zipcode());
            payment.setShipping_phone(payUmoneyVO.getShipping_phone());
            payment.setShipping_phoneverified(payUmoneyVO.getShipping_phoneverified());
            payment.setUnmappedstatus(payUmoneyVO.getUnmappedstatus());
            payment.setPayuMoneyId(payUmoneyVO.getPayuMoneyId());
			return payment;
		}

}
*/