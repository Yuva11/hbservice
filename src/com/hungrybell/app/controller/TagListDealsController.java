package com.hungrybell.app.controller;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hungrybell.app.service.DynamicDataService;
import com.hungrybell.app.vo.request.HomePageRequestVO;
import com.hungrybell.app.vo.request.SearchPagePageRequestVO;
import com.hungrybell.app.vo.response.HomePageResponseVO;
import com.hungrybell.app.vo.response.TagDealsListResponseVO;

@Controller
public class TagListDealsController {

	@Autowired
	DynamicDataService dynamicDataService;

	@RequestMapping(value = "/tagListDeals.do", method = RequestMethod.GET)
	public @ResponseBody TagDealsListResponseVO tagListDeals(
			@RequestParam("tagName") String tagName,
			@RequestParam("userId") String userId,
			@RequestParam("latitude") String lat,
			@RequestParam("longitude") String longitude) {
		return dynamicDataService
				.getAllDealsForTagName(tagName, lat, longitude);
	}

	@RequestMapping(value = "/tagListDealsjson.do", method = RequestMethod.POST, consumes = { "application/json" }, headers = "Accept=application/json")
	@ResponseBody
	public TagDealsListResponseVO tagListDealsJson(@RequestBody String input) {

		SearchPagePageRequestVO searchPageRequestVO = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			searchPageRequestVO = mapper.readValue(input,
					SearchPagePageRequestVO.class);
		
			return dynamicDataService.getAllDealsForTagName(searchPageRequestVO
					.getBody().getSearchString(), searchPageRequestVO.getBody()
					.getLatitude(), searchPageRequestVO.getBody()
					.getLongitude());
	
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
		// System.out.println(">>"+homePageRequestVO.getBody().getUser_id());
		return null;
	}

}
