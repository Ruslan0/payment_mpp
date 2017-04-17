package com.sinsay.spreedly;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpreedlyController {
	
	@Autowired
	private SpreedlyService topicService;
	

	@RequestMapping(method=RequestMethod.POST, value="/gateway")
	public Object getGateWay(@RequestBody SpreedlyGateWay gatewayparam){
		return topicService.getGateWay(gatewayparam);
	}

}
