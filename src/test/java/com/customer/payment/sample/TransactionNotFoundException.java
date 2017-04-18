package com.customer.payment.sample;

import org.springframework.web.bind.annotation.ResponseStatus;

import static com.customer.payment.sample.TransactionNotFoundException.REASON;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ResponseStatus(value = NOT_FOUND, reason = REASON)
public class TransactionNotFoundException extends RuntimeException {
    public static final String REASON = "System was not able to find a transaction by the token provided";

    private static final long serialVersionUID = 2604733909168275292L;
}
