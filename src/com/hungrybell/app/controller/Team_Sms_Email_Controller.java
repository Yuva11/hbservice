package com.hungrybell.app.controller;

import java.io.IOException;
import java.util.ArrayList;

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
public class Team_Sms_Email_Controller {
	DynamicDataService dataService =new DynamicDataService();

	public void sendTeamSmsEmail(String orderidcreate, String first_name,
			String address, String mobile_number, String order_quantityss,
			String order_amount, String merchantname, String dealname,
			String order_type,String teamemail,String team_mobno,String customer_mobileno,String customer_emailid,ArrayList deals,ArrayList quantities) {
		try {
			dataService.sendTeamSmsEmailService(orderidcreate, first_name,
					address, mobile_number, order_quantityss, order_amount,
					merchantname, dealname, order_type,teamemail,team_mobno,customer_mobileno,customer_emailid,deals,quantities);

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}

}
