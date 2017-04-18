package com.customer.payment.config.rabbitmq;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "customer.payment-api.rabbitmq")
public class RabbitMqProperties {
    @Getter
    @Setter
    private String notificationExchange = "payment-api.notification_exchange";

    @Getter
    @Setter
    private String paymentSucceededQueue = "payment-api.payment-succeeded-queue";
}
