package com.hungrybell.app.controller;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.hungrybell.app.service.DynamicDataService;
import com.hungrybell.app.vo.request.UserDetailsRequestVO;
import com.hungrybell.app.vo.response.UserDetailsResponseVo;

@Controller
public class UserDetailsController {

	@Autowired
	DynamicDataService dynamicDataService;

	@RequestMapping(value = "/getUserDetails.do", method = RequestMethod.POST,consumes = { "application/json" }, headers = "Accept=application/json")
	@ResponseBody
	public UserDetailsResponseVo getUserDetails(@RequestBody String input) {
		UserDetailsRequestVO uDetailsRequestVO = null;
		UserDetailsResponseVo userDetailsResponseVo = new UserDetailsResponseVo();
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			uDetailsRequestVO = objectMapper.readValue(input,UserDetailsRequestVO.class);
			userDetailsResponseVo=dynamicDataService.getUserDetails(uDetailsRequestVO.getUserId());
			return userDetailsResponseVo;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return userDetailsResponseVo;
	}
}
