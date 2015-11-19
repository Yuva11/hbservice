package com.hungrybell.app.controller;
import java.io.IOException;
import java.util.ArrayList;

import com.hungrybell.app.vo.request.AdminLoginRequestVO;
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

@Controller
public class AdminLoginController {

	@Autowired
	DynamicDataService dynamicDataService;

	static final Logger logger = Logger.getLogger(ResetPasswordController.class);

	@RequestMapping(value = "/adminLoginPanel.do", method = RequestMethod.POST)
	@ResponseBody
	public AdminLoginStatus adminLoginPanel(@RequestBody String input) {

		AdminLoginStatus status = new AdminLoginStatus();
		ArrayList sList=new ArrayList();
		
		AdminLoginRequestVO resetPassword= null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			resetPassword = mapper.readValue(input,AdminLoginRequestVO.class);
      		status=dynamicDataService.checkAdminLoginPanel(resetPassword.getUser_email(),resetPassword.getConfirm_pass());
		
			
        	} catch (Exception ex) {
        		status.setStatus("failure");
			ex.printStackTrace();
		
		}
		return status;


	}

}


