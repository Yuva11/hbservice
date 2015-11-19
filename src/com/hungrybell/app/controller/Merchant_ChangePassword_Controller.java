package com.hungrybell.app.controller;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hungrybell.app.service.DynamicDataService;
import com.hungrybell.app.vo.request.MerchantPasswordRequestVo;
import com.hungrybell.app.vo.response.MerchantPasswordStatus;

@Controller
public class Merchant_ChangePassword_Controller {
	@Autowired
	DynamicDataService dynamicDataService;

	@RequestMapping(value = "/changeMerchantPassword.do", method = RequestMethod.POST)
	@ResponseBody
	public MerchantPasswordStatus merchantUpdatePassword(@RequestBody String input)
	{
		MerchantPasswordStatus merchantstatus=new MerchantPasswordStatus();
		MerchantPasswordRequestVo merchantPasswordRequestVo=null;
		ObjectMapper objectMapper=new ObjectMapper();
		
		try
		{
			merchantPasswordRequestVo=objectMapper.readValue(input, MerchantPasswordRequestVo.class);
			
			merchantstatus=dynamicDataService.updateMerchantPassword(merchantPasswordRequestVo.getUsername(),merchantPasswordRequestVo.getNewPassword());
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
			merchantstatus.setStatus("fails");
			merchantstatus.setMerchant_password_status("Merchant Password successfully not edited");

		}

		return merchantstatus;
	}

}
