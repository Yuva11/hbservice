package com.hungrybell.app.controller;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hungrybell.app.service.DynamicDataService;
import com.hungrybell.app.vo.request.CheckDistanceRequestVO;

import com.hungrybell.app.vo.response.CheckDistanceResponseVO;


@Controller
// @EnableWebMvc
public class CheckDistanceController {

	@Autowired
	DynamicDataService dynamicDataService;

	@RequestMapping(value = "/checkDistance.do", method = RequestMethod.POST,consumes = { "application/json" }, headers = "Accept=application/json")
	@ResponseBody
	public CheckDistanceResponseVO checkDistance(@RequestBody String input) 
	{
		CheckDistanceRequestVO checkDistancerequest = null;
		CheckDistanceResponseVO checkDistanceResponse = new CheckDistanceResponseVO();
		ObjectMapper mapper = new ObjectMapper();
		try {
			checkDistancerequest = mapper.readValue(input,CheckDistanceRequestVO.class);
			checkDistanceResponse = dynamicDataService.getDistanceDetails(checkDistancerequest.getLatitude(),
					checkDistancerequest.getLongitude(),
					checkDistancerequest.getMerchantbranch_id(),
					checkDistancerequest.getUserId());
			return checkDistanceResponse;

		} catch (Exception ex) {

		}
	return checkDistanceResponse;
	}

}
