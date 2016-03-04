package com.hungrybell.app.controller;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hungrybell.app.service.DynamicDataService;
import com.hungrybell.app.vo.request.CategoryRequestVO;
import com.hungrybell.app.vo.response.CategoryListResponseVO;

@Controller
public class CategoryController {

	@Autowired
	DynamicDataService dynamicService;

	@RequestMapping(value = "/getCategory.do", method = RequestMethod.POST)
	@ResponseBody
	public CategoryListResponseVO  getCategory(@RequestBody String input) {
		CategoryListResponseVO categoryList = null;
		CategoryRequestVO categoryRequestVO = null;
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			categoryRequestVO = objectMapper.readValue(input,CategoryRequestVO.class);
			categoryList = dynamicService.getCategoryList(
					categoryRequestVO.getLatitude(),
					categoryRequestVO.getLongitude(),
					categoryRequestVO.getUserId());
			return categoryList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categoryList;
	}

}
