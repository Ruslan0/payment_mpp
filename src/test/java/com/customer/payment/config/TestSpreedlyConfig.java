package com.customer.payment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.customer.payment.sample.MockSpreedlyService;

import static org.mockito.Mockito.mock;

@Configuration
public class TestSpreedlyConfig {
    @Bean
    public MockSpreedlyService mockEdgecastService() {
        return mock(MockSpreedlyService.class);
    }
}
