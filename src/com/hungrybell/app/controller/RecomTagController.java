package com.hungrybell.app.controller;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.hungrybell.app.date.GetDateFromSystem;
import com.hungrybell.app.service.DynamicDataService;
import com.hungrybell.app.vo.response.HomePageResponseVO;

@Controller
public class RecomTagController {

	
	@Autowired
	DynamicDataService dynamicDataService;
	static final Logger logger = Logger.getLogger(RecomTagController.class);


	@Scheduled(fixedDelay = 28800000)
	public void recomTagCreate() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			GetDateFromSystem getDateFromSystem=new GetDateFromSystem();
			logger.info("recommanded service executed "+getDateFromSystem.getDateFromSystem());
			
			HomePageResponseVO hresVO=  dynamicDataService.getAllDealsForLocationRecomTag();
	
		} catch (Exception ex) 
		{
			ex.printStackTrace();
			
		}
          
		}
}
