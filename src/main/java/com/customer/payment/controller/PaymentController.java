package com.customer.payment.controller;

import com.customer.payment.service.PaymentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@Api(value = "Payments",
        description = "Methods to work with a `payment gateway`",
        protocols = "http, https"
)
@RequestMapping("/payments")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = GET)
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(final PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @RequestMapping(method = GET, value = "/verify/{transactionToken}",
            produces = {APPLICATION_JSON_VALUE, APPLICATION_JSON_UTF8_VALUE})
    public String verify(@PathVariable("transactionToken") final String transactionToken) {
        return paymentService.verify(transactionToken);
    }
}
