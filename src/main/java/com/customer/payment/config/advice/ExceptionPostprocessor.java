package com.customer.payment.config.advice;

import com.netflix.hystrix.exception.HystrixRuntimeException;
import feign.FeignException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static com.customer.payment.helper.ExceptionHandlingHelper.toResponse;
import static java.lang.String.format;
import static org.apache.commons.lang3.StringUtils.substringAfter;
import static org.apache.commons.lang3.StringUtils.substringBeforeLast;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.http.ResponseEntity.status;

@ControllerAdvice
public class ExceptionPostprocessor {

    @ExceptionHandler(HystrixRuntimeException.class)
    public ResponseEntity<String> hystrixRuntimeException(final Exception exception) {
        final Throwable cause = exception.getCause();

        if (cause instanceof FeignException) {
            final FeignException feignException = (FeignException) cause;

            final String message = format("{%s}", substringBeforeLast(substringAfter(feignException.getMessage(), "{"), "}"));

            return status(feignException.status()).contentType(APPLICATION_JSON_UTF8).body(message);
        }

        return toResponse(exception, INTERNAL_SERVER_ERROR, exception.getMessage());
    }
}
