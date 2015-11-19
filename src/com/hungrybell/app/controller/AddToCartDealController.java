package com.hungrybell.app.controller;

import java.io.IOException;

import com.hungrybell.app.vo.response.*;

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

import com.hungrybell.app.model.Deal;
import com.hungrybell.app.service.DynamicDataService;
import com.hungrybell.app.vo.request.AddToCartRequestVO;
import com.hungrybell.app.vo.request.CustomerVO;
import com.hungrybell.app.vo.request.DealUserActionRequestVO;
import com.hungrybell.app.vo.request.HomePageRequestVO;
import com.hungrybell.app.vo.request.SearchPagePageRequestVO;
import com.hungrybell.app.vo.request.SearchPagePageRequestVOACT;
import com.hungrybell.app.vo.response.TagDealsListResponseVO;

@Controller
public class AddToCartDealController {

	@Autowired
	DynamicDataService dynamicDataService;

	@RequestMapping(value = "/addToCartOrderDeal.do", method = RequestMethod.POST, consumes = { "application/json" }, headers = "Accept=application/json")
	@ResponseBody
	public TagDealsListResponseVOAddToCart tagListDealsJsonAddTOCart(
			@RequestBody String input) {
		TagDealsListResponseVOAddToCart tagDealsListResponseVOAddToCart = new TagDealsListResponseVOAddToCart();
		SearchPagePageRequestVOACT searchPageRequestVO = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			searchPageRequestVO = mapper.readValue(input,
					SearchPagePageRequestVOACT.class);

			tagDealsListResponseVOAddToCart = dynamicDataService
					.getAllDealsForBranchNameAddTOCart(searchPageRequestVO
							.getBody().getMerchantbranch_id(),
							searchPageRequestVO.getBody().getLatitude(),
							searchPageRequestVO.getBody().getLongitude());
			return tagDealsListResponseVOAddToCart;

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
