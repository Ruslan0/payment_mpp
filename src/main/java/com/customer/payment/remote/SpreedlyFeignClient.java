package com.customer.payment.remote;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@FeignClient(value = "spreedly", url = "${customer.payment-api.spreedly.api-url}", path = "/v1")
public interface SpreedlyFeignClient {
    @RequestMapping(method = GET, path = "/transactions/{transactionToken}.json",
            consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE,
            headers = "Authorization=Basic ${customer.payment-api.spreedly.authorization-token}")
    String verify(@PathVariable("transactionToken") final String transactionToken);
}
