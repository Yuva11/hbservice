
package com.hungrybell.app.controller;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hungrybell.app.service.DynamicDataService;
import com.hungrybell.app.vo.response.DeliveryTrackingResponseOpinioVO;
import com.hungrybell.app.vo.response.Status;

@Controller
public class DeliveryTrackingOpinioController
{
	@Autowired
	DynamicDataService dynamicDataService;

	@RequestMapping(value = "/trackDeliveryStatusOpinio.do", method = RequestMethod.POST)
/*	@ResponseBody*/
	
	@POST
	@Consumes("application/x-www-form-urlencoded")
	public @ResponseBody Status getDeliveryTrackingStatus(@RequestBody String input) {
		Status status = new Status();
		DeliveryTrackingResponseOpinioVO trakinkResponseVO = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			/*String decodedInput = URLDecoder.decode(input, "UTF-8");
			System.out.println(decodedInput);
			String ss=decodedInput.replace("&", " , ");
			System.out.println(ss);
			
			ss=ss.replace("=", " = ");
			System.out.println(ss);
			
			Gson gson = new Gson();
			String json = gson.toJson(ss);
			System.out.println(json);
			
*/		/*	System.out.println(mapper.readValue(input,DeliveryTrackingResponseOpinioVO.class));
             trakinkResponseVO=mapper.readValue(input,DeliveryTrackingResponseOpinioVO.class);
			
			JSONParser parser = new JSONParser();
			JSONObject json1 = (JSONObject) parser.parse(input);*/

			//System.out.println(trakinkResponseVO.getOrder_code());
			System.out.println(input);
			
			return status;
	
		} catch (Exception ex) {
			ex.printStackTrace();
			status.setCode(0);
			status.setMessage("Delivery Status not Inserted Successfully");
			return status;

		}

	}

}


