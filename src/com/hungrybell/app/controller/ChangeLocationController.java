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
import com.hungrybell.app.vo.request.HomePageRequestVO;
import com.hungrybell.app.vo.response.ChangeLocationResponseVO;
import com.hungrybell.app.vo.response.HomePageResponseVO;

@Controller
// @EnableWebMvc
public class ChangeLocationController {

	@Autowired
	DynamicDataService dynamicDataService;

	// change location

	@RequestMapping(value = "/changeLocation.do", method = RequestMethod.POST, consumes = { "application/json" }, headers = "Accept=application/json")
	@ResponseBody
	public ChangeLocationResponseVO changeLocation(@RequestBody String input) {
		System.out.println(input);
		ChangeLocationRequestVO changeLocationRequestVO = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			changeLocationRequestVO = mapper.readValue(input,
					ChangeLocationRequestVO.class);

			ChangeLocationResponseVO hresVO = dynamicDataService
					.getChangeAllLocationList(changeLocationRequestVO.getBody()
							.getLatitude(), changeLocationRequestVO.getBody()
							.getLongitude());
			return hresVO;

		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
