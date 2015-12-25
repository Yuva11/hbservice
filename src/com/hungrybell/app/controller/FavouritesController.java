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
import org.springframework.web.bind.annotation.ResponseBody;

import com.hungrybell.app.service.DynamicDataService;
import com.hungrybell.app.vo.request.HomePageRequestFavTagVO;
import com.hungrybell.app.vo.response.HomePageFavTagResponseVO;


@Controller
// @EnableWebMvc
public class FavouritesController {
	@Autowired
	DynamicDataService dynamicDataService;
	@RequestMapping(value = "/newHomePagejsonForFavTag.do", method = RequestMethod.POST, consumes = { "application/json" }, headers = "Accept=application/json")
	@ResponseBody
	public HomePageFavTagResponseVO newHomePageJsonForFavTag(@RequestBody String input) {
		System.out.println(input);
		HomePageFavTagResponseVO homePageResponseVO = new HomePageFavTagResponseVO();
		HomePageRequestFavTagVO homePageRequestVO = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			homePageRequestVO = mapper
					.readValue(input, HomePageRequestFavTagVO.class);
			System.out.println(homePageRequestVO.getBody().getUser_id());
			homePageResponseVO = dynamicDataService.getAllHomePageDataForFavTag(homePageRequestVO.getBody().getLatitude(),homePageRequestVO.getBody().getLongitude(),homePageRequestVO.getBody().getUser_id());
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
