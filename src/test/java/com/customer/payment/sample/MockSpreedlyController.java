package com.customer.payment.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/v1")
public class MockSpreedlyController {
    private final MockSpreedlyService spreedlyService;

    @Autowired
    public MockSpreedlyController(final MockSpreedlyService spreedlyService) {
        this.spreedlyService = spreedlyService;
    }

    @RequestMapping(method = GET, path = "/transactions/{transaction_token}.json",
            consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public String verify(@RequestHeader("Authorization") final String authorizationToken,
                         @PathVariable("transaction_token") final String transactionToken) {
        return spreedlyService.verify(authorizationToken, transactionToken);
    }
}
