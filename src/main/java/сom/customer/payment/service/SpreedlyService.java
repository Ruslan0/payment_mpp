package сom.customer.payment.service;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import сom.customer.payment.temp.SpreedlyGateWay;

@Service
public class SpreedlyService {
	
	private  static final String plainCreds = "NMZajRzFonIo6tyliG3oU7viSTx:2zEEkrZ4nvWNpAn4BbJCHpjhgXJhUlqstRXdZl4l4Z4i4lWV0YLbejfvAWClKRdA";
	private  static final String spreedly_url = "https://core.spreedly.com/v1/";
	
	public Object getGateWay(SpreedlyGateWay gatewayparam) {
		
		RestTemplate restTemplate = new RestTemplate();
		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);		

		String url = spreedly_url +"gateways.json";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.add("Authorization", "Basic " + base64Creds);

		HttpEntity<?> entity = new HttpEntity<Object>(gatewayparam,headers);
		return restTemplate.postForObject(url, entity, Object.class);
	}
}

