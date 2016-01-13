
package com.hungrybell.app.controller;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hungrybell.app.service.DynamicDataService;
import com.hungrybell.app.vo.request.UpdateUserDetailsRequestVO;
import com.hungrybell.app.vo.request.UserDetailsRequestVO;
import com.hungrybell.app.vo.response.UpdateUserDetailsResponseVo;
import com.hungrybell.app.vo.response.UserDetailsResponseVo;

@Controller
public class UpdateUserDetailsController {

	@Autowired
	DynamicDataService dynamicDataService;

	@RequestMapping(value = "/getUpdateUserDetails.do", method = RequestMethod.POST,consumes = { "application/json" }, headers = "Accept=application/json")
	@ResponseBody
	public UpdateUserDetailsResponseVo getUserDetails(@RequestBody String input) {
		UpdateUserDetailsRequestVO updateUserDetailsRequestVO = null;
		ObjectMapper objectMapper = new ObjectMapper();
		UpdateUserDetailsResponseVo updateUserDetailsResponseVo = new UpdateUserDetailsResponseVo();
		try {
			updateUserDetailsRequestVO = objectMapper.readValue(input,UpdateUserDetailsRequestVO.class);
			updateUserDetailsResponseVo=dynamicDataService.getUpdateUserDetails(
					updateUserDetailsRequestVO.getUserId(),
					updateUserDetailsRequestVO.getUserName(),
					updateUserDetailsRequestVO.getUserEmail(),
					updateUserDetailsRequestVO.getUser_Mob_No(),
					updateUserDetailsRequestVO.getDeviceId(),
					updateUserDetailsRequestVO.getBranchId(),
					updateUserDetailsRequestVO.getUserAddress(),
					updateUserDetailsRequestVO.getLatitude(),
					updateUserDetailsRequestVO.getLongitude());
			
			return updateUserDetailsResponseVo;

		} catch (Exception e) {
			updateUserDetailsResponseVo.setStatus("failure");
		}
		return updateUserDetailsResponseVo;
	}
}
