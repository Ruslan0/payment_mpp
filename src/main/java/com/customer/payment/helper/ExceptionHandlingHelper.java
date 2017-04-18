package com.customer.payment.helper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;
import java.util.stream.Stream;

import static com.fasterxml.jackson.databind.util.ISO8601Utils.format;
import static java.util.stream.Collectors.joining;
import static org.apache.commons.lang3.ArrayUtils.isNotEmpty;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.apache.commons.lang3.SystemUtils.LINE_SEPARATOR;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.http.ResponseEntity.status;

@Log4j
public class ExceptionHandlingHelper {
    public static final TimeZone UTC_TIMEZONE = TimeZone.getTimeZone("UTC");

    public static final String MESSAGE_ATTRIBUTE = "message";

    public static final String STATUS_ATTRIBUTE = "status";

    public static final String TIMESTAMP_ATTRIBUTE = "timestamp";

    public static final String ERROR_ATTRIBUTE = "error";

    public static final String EXCEPTION_ATTRIBUTE = "exception";

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static ResponseEntity<String> toResponse(final Exception exception,
                                                    final HttpStatus httpStatus,
                                                    final String... messagesArray) {
        final Map<String, Object> attributes = new LinkedHashMap<>();

        attributes.put(TIMESTAMP_ATTRIBUTE, format(new Date(), false, UTC_TIMEZONE));
        attributes.put(STATUS_ATTRIBUTE, httpStatus.value());
        attributes.put(ERROR_ATTRIBUTE, httpStatus.getReasonPhrase());
        attributes.put(EXCEPTION_ATTRIBUTE, exception.getClass().getCanonicalName());

        if (isNotEmpty(messagesArray)) {
            final String message = Stream.of(messagesArray)
                    .map(StringUtils::trimToNull)
                    .filter(Objects::nonNull)
                    .collect(joining(LINE_SEPARATOR));

            if (isNotBlank(message)) {
                attributes.put(MESSAGE_ATTRIBUTE, message);
            }
        } else {
            attributes.put(MESSAGE_ATTRIBUTE, exception.getMessage());
        }

        return status(httpStatus).contentType(APPLICATION_JSON_UTF8).body(toJson(exception, attributes));
    }

    private static String toJson(final Exception exception, final Map<String, Object> attributes) {
        try {
            return OBJECT_MAPPER.writeValueAsString(attributes);
        } catch (final JsonProcessingException ignored) {
            return exception.getMessage();
        }
    }
}
