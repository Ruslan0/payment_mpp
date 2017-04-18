package com.customer.payment.config.spreedly;

import com.customer.payment.remote.SpreedlyFeignClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpreedlyClientConfig {
    @Bean
    @ConditionalOnProperty(prefix = "customer.payment-api.spreedly", name = {"authorization-token", "api-url"})
    public SpreedlyClient remoteEdgecastClient(final SpreedlyFeignClient spreedlyFeignClient) {
        return new SpreedlyClient(spreedlyFeignClient);
    }
}
