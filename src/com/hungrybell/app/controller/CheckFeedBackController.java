
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
public class CheckFeedBackController {

	@Autowired
	DynamicDataService dynamicDataService;
		
	
	static final Logger logger = Logger.getLogger(CheckFeedBackController.class);

		@RequestMapping(value = "/checkFeedback.do", method = RequestMethod.POST)
		@ResponseBody
		public Status checkFeedback(@RequestBody String input) 
		{
			Status status=new Status();
			FeedbackCheckRequestVO feedbackRequestVO = null;
			ObjectMapper mapper = new ObjectMapper();
			try
			{
		
				
				feedbackRequestVO = mapper.readValue(input,	FeedbackCheckRequestVO.class);
				System.out.print("----orders-user---id----"+feedbackRequestVO.getUser_id());
				
				logger.info("---orders-user---id----"+ feedbackRequestVO.getUser_id());
				
				status=dynamicDataService.checkFeedback(feedbackRequestVO.getUser_id());
     			return status;

			} catch (Exception ex) 
			{
				ex.printStackTrace();
				status.setCode(0);
				status.setMessage("FeedBack Not Found");
				return status;
				
			
			}

	}

}

