package com.customer.payment.config.rabbitmq;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.springframework.amqp.core.BindingBuilder.bind;

@Configuration
public class RabbitMqConfig {
    @Bean
    public AmqpAdmin amqpAdmin(final ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public FanoutExchange notificationExchange(@Value("${customer.payment-api.rabbitmq.notification-exchange}") final String exchange) {
        return new FanoutExchange(exchange);
    }

    @Bean
    public Queue paymentSucceededQueue(@Value("${customer.payment-api.rabbitmq.payment-succeeded-queue}") final String queue) {
        return new Queue(queue);
    }

    @Bean
    public Binding siteDataChangedQueueBinding(final Queue paymentSucceededQueue, final FanoutExchange notificationExchange) {
        return bind(paymentSucceededQueue).to(notificationExchange);
    }
}
