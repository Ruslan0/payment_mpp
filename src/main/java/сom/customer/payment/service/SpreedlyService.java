package сom.customer.payment.service;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import сom.customer.payment.model.SpreedlyGateWay;

@Service
public class SpreedlyService {
	
	private  static final String plainCreds = "NMZajRzFonIo6tyliG3oU7viSTx:2zEEkrZ4nvWNpAn4BbJCHpjhgXJhUlqstRXdZl4l4Z4i4lWV0YLbejfvAWClKRdA";
	private  static final String spreedly_url = "https://core.spreedly.com/v1/";
	
	private HttpHeaders getHeaders() {
		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);		
	
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.add("Authorization", "Basic " + base64Creds);
	    return headers;
	}
	
	public Object getGateWay(SpreedlyGateWay gatewayparam) {
		return new RestTemplate().postForObject(spreedly_url +"gateways.json", new HttpEntity<Object>(gatewayparam,getHeaders()), Object.class);
	}

	public Object payment(Object gatewayparam) {
		return new RestTemplate().postForObject(spreedly_url +"gateways.json", new HttpEntity<Object>(gatewayparam,getHeaders()), Object.class);
	}
}

