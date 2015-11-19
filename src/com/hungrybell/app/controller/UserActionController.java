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

import com.hungrybell.app.service.DynamicDataService;
import com.hungrybell.app.vo.request.DealUserActionRequestVO;
import com.hungrybell.app.vo.request.HomePageRequestVO;
import com.hungrybell.app.vo.response.TagDealsListResponseVO;

@Controller
public class UserActionController {

	//userlike
	//userfav
	//usershare
	
	@Autowired
	DynamicDataService dynamicDataService;
	
	@RequestMapping(value="/userLike.do", method=RequestMethod.POST)
	public @ResponseBody String userLike(
			@RequestParam("userId")String userId,
			@RequestParam("dealId")String dealId
			){
		dynamicDataService.saveDealLiked(userId, dealId);
		return "success";
	}
	@RequestMapping(value="/userFav.do", method=RequestMethod.POST)
	public @ResponseBody String userFav(
			@RequestParam("userId")String userId,
			@RequestParam("dealId")String dealId
			){
		dynamicDataService.saveDealFavourited(userId, dealId);
		return "success";
	}
	@RequestMapping(value="/userShare.do", method=RequestMethod.POST)
	public @ResponseBody String userShare(
			@RequestParam("userId")String userId,
			@RequestParam("dealId")String dealId
			){
		dynamicDataService.saveDealShared(userId, dealId);
		return "success";
	}
	@RequestMapping(value="/userLikejson.do", method=RequestMethod.POST,consumes = {"application/json"},headers="Accept=application/json")
	@ResponseBody 
	public String userLikeJson(@RequestBody String input){
		
		DealUserActionRequestVO dealUserActionRequestVO=null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			dealUserActionRequestVO=mapper.readValue(input, DealUserActionRequestVO.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		dynamicDataService.saveDealLiked(dealUserActionRequestVO.getBody().getUserId(),dealUserActionRequestVO.getBody().getDealId());
		return "success";
	}
	
	@RequestMapping(value="/userFavjson.do", method=RequestMethod.POST,consumes = {"application/json"},headers="Accept=application/json")
	@ResponseBody 
	public String userFavJson(@RequestBody String input){
		
		DealUserActionRequestVO dealUserActionRequestVO=null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			dealUserActionRequestVO=mapper.readValue(input, DealUserActionRequestVO.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		dynamicDataService.saveDealFavourited(dealUserActionRequestVO.getBody().getUserId(),dealUserActionRequestVO.getBody().getDealId());
		return "success";
	}
	
	
	@RequestMapping(value="/userSharejson.do", method=RequestMethod.POST,consumes = {"application/json"},headers="Accept=application/json")
	@ResponseBody 
	public String userShareJson(@RequestBody String input){
		
		DealUserActionRequestVO dealUserActionRequestVO=null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			dealUserActionRequestVO=mapper.readValue(input, DealUserActionRequestVO.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		dynamicDataService.saveDealShared(dealUserActionRequestVO.getBody().getUserId(),dealUserActionRequestVO.getBody().getDealId());
		return "success";
	}
	
	
	@RequestMapping(value="/userViewjson.do", method=RequestMethod.POST,consumes = {"application/json"},headers="Accept=application/json")
	@ResponseBody 
	public String userViewjson(@RequestBody String input){
		
		DealUserActionRequestVO dealUserActionRequestVO=null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			dealUserActionRequestVO=mapper.readValue(input, DealUserActionRequestVO.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		dynamicDataService.saveDealViewed(dealUserActionRequestVO.getBody().getUserId(),dealUserActionRequestVO.getBody().getDealId());
		return "success";
	}
	
	
}
