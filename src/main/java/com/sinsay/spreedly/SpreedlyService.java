package com.sinsay.spreedly;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SpreedlyService {
	
	public Object getGateWay(SpreedlyGateWay gatewayparam) {
		
		RestTemplate restTemplate = new RestTemplate();
		String plainCreds = "NMZajRzFonIo6tyliG3oU7viSTx:2zEEkrZ4nvWNpAn4BbJCHpjhgXJhUlqstRXdZl4l4Z4i4lWV0YLbejfvAWClKRdA";
		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);		

		String url = "https://core.spreedly.com/v1/gateways.json";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.add("Authorization", "Basic " + base64Creds);

		HttpEntity<?> entity = new HttpEntity<Object>(gatewayparam,headers);
		return restTemplate.postForObject(url, entity, Object.class);
	}
}

