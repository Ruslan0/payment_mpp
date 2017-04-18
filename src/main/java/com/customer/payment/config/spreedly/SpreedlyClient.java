package com.customer.payment.config.spreedly;

import com.customer.payment.remote.SpreedlyFeignClient;
import lombok.Getter;

public class SpreedlyClient {
    @Getter
    private final SpreedlyFeignClient spreedlyFeignClient;


    public SpreedlyClient(final SpreedlyFeignClient spreedlyFeignClient) {
        this.spreedlyFeignClient = spreedlyFeignClient;
    }

    public String verify(final String transactionToken) {
        return spreedlyFeignClient.verify(transactionToken);
    }
}