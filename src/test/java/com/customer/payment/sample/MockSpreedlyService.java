package com.customer.payment.sample;

public interface MockSpreedlyService {
    String verify(final String authorizationToken, final String transactionToken);
}
