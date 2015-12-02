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
import com.hungrybell.app.vo.request.HomePageRequestVO;
import com.hungrybell.app.vo.response.HomePageResponseVO;

@Controller
// @EnableWebMvc
public class NewHomeController {

	@Autowired
	DynamicDataService dynamicDataService;

	@RequestMapping(value = "/newHomePage.do", method = RequestMethod.GET)
	public @ResponseBody HomePageResponseVO newHomePage(
			@RequestParam("latitude") String lat,
			@RequestParam("longitude") String longitude,
			@RequestParam("userId") String userId) {
		User user = null;
		if (userId == null || userId.trim().equals("")) {
			// user=dynamicDataService.getUser();
		} else {
			user = new User();
			user.setId(new Long(userId));
		}

		HomePageResponseVO hresVO = dynamicDataService.getAllHomePageData(lat,
				longitude);
		hresVO.setUser_id(user.getId());
		return hresVO;
	}

	@RequestMapping(value = "/newHomePagejson.do", method = RequestMethod.POST, consumes = { "application/json" }, headers = "Accept=application/json")
	@ResponseBody
	public HomePageResponseVO newHomePageJson(@RequestBody String input) {
		System.out.println(input);
		HomePageResponseVO homePageResponseVO = new HomePageResponseVO();
		HomePageRequestVO homePageRequestVO = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			homePageRequestVO = mapper
					.readValue(input, HomePageRequestVO.class);
			User user = null;
			String userId = homePageRequestVO.getBody().getUser_id();
			String device_id = homePageRequestVO.getBody().getDevice_id();
			String email = homePageRequestVO.getBody().getEmail();

			/*
			 * if(userId== null || userId.trim().equals("")) {
			 * if(device_id!=null) { //get user id from user table by devise_id
			 * user=dynamicDataService.getUserId(device_id,email); }else{ user =
			 * dynamicDataService.getUserFromEmail(device_id, email); } } else {
			 * 
			 * 
			 * user = new User(); user.setId(new Long(userId));
			 * user.setDevice_id(device_id); user.setEmail(email);
			 * 
			 * 
			 * }
			 */if (device_id != null) {
				// get user id from user table by devise_id
				user = dynamicDataService.getUserId(device_id, email);
			} else {
				user = dynamicDataService.getUserFromEmail(device_id, email);
			}
			homePageResponseVO = dynamicDataService.getAllHomePageData(
					homePageRequestVO.getBody().getLatitude(),
					homePageRequestVO.getBody().getLongitude());
			homePageResponseVO.setUser_id(user.getId());
			homePageResponseVO.setDevice_id(user.getDevice_id());

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
		return homePageResponseVO;
	}
}
