package com.customer.payment.config;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import static org.mockito.Mockito.mock;

@Configuration
public class TestRabbitConfig {
    @Bean
    @Primary
    public RabbitTemplate mockRabbitTemplate() {
        return mock(RabbitTemplate.class);
    }

    @Bean
    @Primary
    public AmqpAdmin mockAmqpAdmin() {
        return mock(AmqpAdmin.class);
    }
}
