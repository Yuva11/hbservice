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
import com.hungrybell.app.vo.request.CustomerVO;
import com.hungrybell.app.vo.request.DealUserActionRequestVO;
import com.hungrybell.app.vo.request.HomePageRequestVO;
import com.hungrybell.app.vo.response.TagDealsListResponseVO;

@Controller
public class CODController {

	@Autowired
	DynamicDataService dynamicDataService;

	@RequestMapping(value = "/orderDetails.do", method = RequestMethod.POST)
	@ResponseBody
	public Status customerAdd(@RequestBody String input) {

		Status status=new Status();
		CustomerVO customerVO2 = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			customerVO2 = mapper.readValue(input, CustomerVO.class);

			dynamicDataService.saveUser(customerVO2.getBody().getId(),
					customerVO2.getBody().getFirst_name(), customerVO2
							.getBody().getUsername_email(), customerVO2
							.getBody().getMobile_number(), customerVO2
							.getBody().getAddress(), customerVO2.getBody()
							.getUser_id());
			dynamicDataService.saveNewOrderDetails(customerVO2.getBody()
					.getLongitude(), customerVO2.getBody().getLatitude(),
					customerVO2.getBody().getAddress(), customerVO2.getBody()
							.getLandmark(), customerVO2.getBody()
							.getOrder_type(), customerVO2.getBody()
							.getOrder_quantity(), customerVO2.getBody()
							.getOrder_amount(), customerVO2.getBody()
							.getDeal_id(), customerVO2.getBody()
							.getDelivery_status(), customerVO2.getBody()
							.getStatus(), customerVO2.getBody().getUser_id(),
					customerVO2.getBody().getMobile_number(), customerVO2
							.getBody().getFirst_name(), customerVO2.getBody()
							.getUsername_email());

			status.setCode(1);
			status.setMessage("Order Placed Successfully");
		//	status.setOrderid("");
			return status;

		} catch (Exception ex) {
			ex.printStackTrace();
			status.setCode(0);
			status.setMessage("Order Placed not Successfully");
		//	status.setOrderid("");
			return status;
			
		}

	}

}
