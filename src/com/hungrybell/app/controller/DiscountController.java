package com.hungrybell.app.controller;

import java.io.IOException;

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

import com.hungrybell.app.model.User;
import com.hungrybell.app.service.DynamicDataService;
import com.hungrybell.app.vo.request.ChangeLocationRequestVO;
import com.hungrybell.app.vo.request.CheckDiscountCodeRequestVO;
import com.hungrybell.app.vo.request.HomePageRequestVO;
import com.hungrybell.app.vo.response.ChangeLocationResponseVO;
import com.hungrybell.app.vo.response.CheckDiscountCodeResponseVO;
import com.hungrybell.app.vo.response.HomePageResponseVO;

@Controller
// @EnableWebMvc
public class DiscountController {

	@Autowired
	DynamicDataService dynamicDataService;

	@RequestMapping(value = "/checkDiscountCode.do", method = RequestMethod.POST,consumes = { "application/json" }, headers = "Accept=application/json")
	@ResponseBody
	public CheckDiscountCodeResponseVO checkDisountCode(@RequestBody String input) 
	{
		CheckDiscountCodeRequestVO checkDiscountCodeRequestVO = null;
		CheckDiscountCodeResponseVO hrefVo = new CheckDiscountCodeResponseVO();
		ObjectMapper mapper = new ObjectMapper();
		try {
			checkDiscountCodeRequestVO = mapper.readValue(input,CheckDiscountCodeRequestVO.class);
			hrefVo = dynamicDataService.getCheckDiscountCode(
					checkDiscountCodeRequestVO.getCoupanCode(),
					checkDiscountCodeRequestVO.getMerchantbranch_id(),
					checkDiscountCodeRequestVO.getTotal_order_value(),
					checkDiscountCodeRequestVO.getUser_id());
			return hrefVo;

		} catch (Exception ex) {

		}
		CheckDiscountCodeResponseVO hrefVo1 = new CheckDiscountCodeResponseVO();

		return hrefVo1;
	}

}
