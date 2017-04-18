package com.customer.payment.service;

import com.customer.payment.config.spreedly.SpreedlyClient;
import com.customer.payment.model.GatewayRequest;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentService {

    private static final String plainCreds = "NMZajRzFonIo6tyliG3oU7viSTx:2zEEkrZ4nvWNpAn4BbJCHpjhgXJhUlqstRXdZl4l4Z4i4lWV0YLbejfvAWClKRdA";
    private static final String spreedly_url = "https://core.spreedly.com/v1/";

    private final SpreedlyClient spreedlyClient;

    @Autowired
    public PaymentService(final SpreedlyClient spreedlyClient) {
        this.spreedlyClient = spreedlyClient;
    }

    private HttpHeaders getHeaders() {
        final byte[] plainCredsBytes = plainCreds.getBytes();
        final byte[] base64CredsBytes = Base64.encodeBase64(plainCredsBytes);
        final String base64Creds = new String(base64CredsBytes);

        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", "Basic " + base64Creds);
        return headers;
    }

    public Object getGateWay(final GatewayRequest gatewayparam) {
        return new RestTemplate().postForObject(spreedly_url + "gateways.json", new HttpEntity<Object>(gatewayparam, getHeaders()), Object.class);
    }

    public Object payment(final Object gatewayparam) {
        return new RestTemplate().postForObject(spreedly_url + "gateways.json", new HttpEntity<Object>(gatewayparam, getHeaders()), Object.class);
    }

    public String verify(final String transactionToken) {
        return spreedlyClient.verify(transactionToken);
    }
}

