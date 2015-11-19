

package com.hungrybell.app.controller;

import java.io.IOException;
import java.util.ArrayList;

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
import com.hungrybell.app.vo.request.MerchantLoginRequestVO;
import com.hungrybell.app.vo.request.MerchantOrderRequestVO;
import com.hungrybell.app.vo.request.SearchPagePageRequestVO;
import com.hungrybell.app.vo.request.SearchPagePageRequestVOACT;
import com.hungrybell.app.vo.response.TagDealsListResponseVO;

@Controller
public class OrderDetailsController {

	@Autowired
	DynamicDataService dynamicDataService;

	static final Logger logger = Logger.getLogger(AddToCartController.class);

	@RequestMapping(value = "/lastsevendaysorder.do", method = RequestMethod.POST)
	@ResponseBody
	public MerchantOrderStatus merchantOrders(@RequestBody String input) {

		MerchantOrderStatus status = new MerchantOrderStatus();
		ArrayList sList=new ArrayList();
		
		MerchantOrderRequestVO merchantorder = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			merchantorder = mapper.readValue(input,MerchantOrderRequestVO.class);

			status=dynamicDataService.merchantOrders(merchantorder.getMerchant_branch_id());
        	} catch (Exception ex) {
			ex.printStackTrace();
		
		}
		return status;


	}

}

