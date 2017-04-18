package com.customer.payment.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.customer.payment.model.GatewaySpreedly;
import com.customer.payment.service.PaymentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Payments",
        description = "Methods to work with a `payment gateway`",
        protocols = "http, https"
)
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(final PaymentService paymentService) {
        this.paymentService = paymentService;
    }

	@RequestMapping(method=RequestMethod.POST, value="/gateway")
	public Object getGateWay(@RequestBody GatewaySpreedly gatewayparam){
		return paymentService.getGateWay_Token(gatewayparam);
	}

	@RequestMapping(method=RequestMethod.POST, value="/purchase{gateway_token}")
	public Object purchaseTokenized(@RequestBody GatewaySpreedly gatewayparam,  @PathVariable String gateway_token){
		return paymentService.payment(gateway_token, gatewayparam);
	}
	@ApiOperation(value = "Verifies a status of a transaction by the token provided", response = String.class)
    @RequestMapping(method = GET, value = "/verify/{transactionToken}",
            produces = {APPLICATION_JSON_VALUE, APPLICATION_JSON_UTF8_VALUE})
    public String verify(@PathVariable("transactionToken") final String transactionToken) {
        return paymentService.verify(transactionToken);
    }

    @ApiOperation(value = "Verifies a status of a transaction by the token provided", response = String.class)
    @RequestMapping(method = POST, value = "/purchasecredit/{transactionToken}",
            produces = {APPLICATION_JSON_VALUE, APPLICATION_JSON_UTF8_VALUE})
    public String purchase(@PathVariable("transactionToken") final String transactionToken) {
        return paymentService.purchase(transactionToken);
    }
}
