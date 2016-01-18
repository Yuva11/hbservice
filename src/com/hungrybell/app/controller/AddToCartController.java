package com.hungrybell.app.controller;

import java.io.IOException;

import com.hungrybell.app.vo.response.*;

import org.apache.log4j.Logger;
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
import com.hungrybell.app.vo.request.SearchPagePageRequestVO;
import com.hungrybell.app.vo.request.SearchPagePageRequestVOACT;
import com.hungrybell.app.vo.response.TagDealsListResponseVO;



@Controller
public class AddToCartController {

	@Autowired
	DynamicDataService dynamicDataService;

	static final Logger logger = Logger.getLogger(AddToCartController.class);

	@RequestMapping(value = "/addToCartOrderDetails.do", method = RequestMethod.POST)
	@ResponseBody
	public Status addToCartOrder(@RequestBody String input) {

		Status status = new Status();
		AddToCartRequestVO addToCartRequestVO = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			addToCartRequestVO = mapper.readValue(input,
					AddToCartRequestVO.class);

			dynamicDataService.saveUser(addToCartRequestVO.getBody()
					.getUser_id(),
					addToCartRequestVO.getBody().getFirst_name(),
					addToCartRequestVO.getBody().getEmail(), addToCartRequestVO
							.getBody().getMobile_number(), addToCartRequestVO
							.getBody().getAddress(), addToCartRequestVO
							.getBody().getUser_id());

			logger.info("---orders-----"
					+ addToCartRequestVO.getBody().getOrders());

			status = dynamicDataService.saveAddToCartOrderDetails(
					addToCartRequestVO.getBody().getLongitude(),
					addToCartRequestVO.getBody().getLatitude(),
					addToCartRequestVO.getBody().getAddress(),
					addToCartRequestVO.getBody().getLandmark(),
					addToCartRequestVO.getBody().getOrder_type(),
					addToCartRequestVO.getBody().getOrders(),
					addToCartRequestVO.getBody().getOrder_amount(),
					addToCartRequestVO.getBody().getDelivery_status(),
					addToCartRequestVO.getBody().getStatus(),
					addToCartRequestVO.getBody().getUser_id(),
					addToCartRequestVO.getBody().getMobile_number(),
					addToCartRequestVO.getBody().getFirst_name(),
					addToCartRequestVO.getBody().getEmail(), addToCartRequestVO
							.getBody().getDiscount_method(), addToCartRequestVO
							.getBody().getDiscount_amount(), addToCartRequestVO
							.getBody().getCoupon_code(),
							addToCartRequestVO.getBody().getDelivery_date(),
							addToCartRequestVO.getBody().getDelivery_time()
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
