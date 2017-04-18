package com.customer.payment.config.spreedly;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "customer.payment-api.spreedly")
public class SpreedlyProperties {
    @Getter
    @Setter
    private String authorizationToken;

    @Getter
    @Setter
    private String gatewayToken;


    @Getter
    @Setter
    private String apiUrl;

    @Getter
    @Setter
    private boolean stub;
}
