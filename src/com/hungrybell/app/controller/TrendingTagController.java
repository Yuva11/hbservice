package com.hungrybell.app.controller;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hungrybell.app.date.GetDateFromSystem;
import com.hungrybell.app.model.User;
import com.hungrybell.app.service.DynamicDataService;
import com.hungrybell.app.vo.request.HomePageRequestVO;
import com.hungrybell.app.vo.response.HomePageResponseVO;


@Controller
// @EnableWebMvc
public class TrendingTagController {
	
	@Autowired
	DynamicDataService dynamicDataService;
	static final Logger logger = Logger.getLogger(TrendingTagController.class);


	@Scheduled(fixedDelay = 28800000)
	public void trendingTagCreate() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			GetDateFromSystem getDateFromSystem=new GetDateFromSystem();
			logger.info("trending service executed "+getDateFromSystem.getDateFromSystem());
			
			HomePageResponseVO hresVO=  dynamicDataService.getAllDealsForLocationTrendingTag();
	
		} catch (Exception ex) 
		{
			ex.printStackTrace();
			
		}
          
		}
}
