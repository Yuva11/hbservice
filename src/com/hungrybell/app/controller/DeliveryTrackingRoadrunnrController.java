
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
import com.hungrybell.app.vo.request.FeedbackCheckRequestVO;
import com.hungrybell.app.vo.request.FeedbackRequestVO;
import com.hungrybell.app.vo.request.HomePageRequestVO;
import com.hungrybell.app.vo.request.SearchPagePageRequestVO;
import com.hungrybell.app.vo.request.SearchPagePageRequestVOACT;
import com.hungrybell.app.vo.response.TagDealsListResponseVO;

@Controller
public class DeliveryTrackingRoadrunnrController
{

	@Autowired
	DynamicDataService dynamicDataService;

	@RequestMapping(value = "/trackDeliveryStatusRoadrunnr.do", method = RequestMethod.POST)
	@ResponseBody
	public Status getDeliveryTrackingStatus(@RequestBody String input) {

		Status status = new Status();
		DeliveryTrackingResponseRoadRunnrVO trakinkResponseVO = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			trakinkResponseVO = mapper.readValue(input,
					DeliveryTrackingResponseRoadRunnrVO.class);
		status = dynamicDataService.getDeliveryTrackingRoadRunnrStatus(trakinkResponseVO.getOrder_id(),trakinkResponseVO.getStatus(),trakinkResponseVO.getDriver_name(),trakinkResponseVO.getDriver_number(),trakinkResponseVO.getTimestamp());
			return status;

		} catch (Exception ex) {
			ex.printStackTrace();
			status.setCode(0);
			status.setMessage("Delivery Status not Inserted Successfully");
			return status;

		}

	}

}
