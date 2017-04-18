package com.customer.payment.rest;

import com.customer.payment.TestConfiguration;
import com.customer.payment.sample.MockSpreedlyService;
import com.customer.payment.sample.TransactionNotFoundException;
import com.customer.payment.util.TestUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.restdocs.JUnitRestDocumentation;

import static com.customer.payment.util.TestUtils.initRestDocuments;
import static com.customer.payment.util.TestUtils.readJsonFile;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.endsWith;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class PaymentApiTest extends TestConfiguration {

    @Rule
    public final JUnitRestDocumentation restDocumentation = initRestDocuments();

    @Autowired
    private MockSpreedlyService spreedlyService;

    @Value("${customer.payment-api.spreedly.authorization-token}")
    private String authorizationToken;

    @Before
    public void setUp() {
        mockMvc = TestUtils.initMockMvc(context, restDocumentation);
    }

    @After
    public void tearDown() {
        mockMvc = null;

        reset(spreedlyService);
    }

    @Test
    public void verifyPayment() throws Exception {
        final String transactionToken = "KjMjLPUNTJycq6g4ruUgDkEJ2rr";

        when(spreedlyService.verify(endsWith(authorizationToken), eq(transactionToken)))
                .thenReturn(readJsonFile("/sample/json/verification_response.json"));

        mockMvc.perform(get("/payments/verify/{transactionToken}", transactionToken))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("transaction.token", is(transactionToken)));
    }

    @Test
    public void verifyPaymentByIncorrectToken() throws Exception {
        when(spreedlyService.verify(endsWith(authorizationToken), anyString()))
                .thenThrow(new TransactionNotFoundException());

        mockMvc.perform(get("/payments/verify/{transactionToken}", "Unknown_transaction"))
                .andExpect(status().isNotFound())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8_VALUE))
                .andExpect(jsonPath("message", is(TransactionNotFoundException.REASON)));
    }
}
