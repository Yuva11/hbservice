
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
import com.hungrybell.app.vo.request.CategoryDealRequestVO;
import com.hungrybell.app.vo.request.HomePageRequestVO;
import com.hungrybell.app.vo.request.SearchPagePageRequestVO;
import com.hungrybell.app.vo.response.HomePageResponseVO;
import com.hungrybell.app.vo.response.TagDealsListResponseVO;

@Controller
public class CategoryDealController {

	@Autowired
	DynamicDataService dynamicDataService;


	@RequestMapping(value = "/getCategoryDeals.do", method = RequestMethod.POST, consumes = { "application/json" }, headers = "Accept=application/json")
	@ResponseBody
	public TagDealsListResponseVO tagListDealsJson(@RequestBody String input) {

		CategoryDealRequestVO categoryDealRequestVO = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			categoryDealRequestVO = mapper.readValue(input,CategoryDealRequestVO.class);
		
			return dynamicDataService.getCategoryDealDetails(
					categoryDealRequestVO.getLatitude(),
					categoryDealRequestVO.getLongitude(),
					categoryDealRequestVO.getCategory_name()
					);
	
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
