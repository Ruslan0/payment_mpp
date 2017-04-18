package com.customer.payment.util;

import lombok.experimental.UtilityClass;
import lombok.extern.log4j.Log4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.restdocs.JUnitRestDocumentation;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.util.stream.Collectors;

import static com.google.common.io.Files.readLines;
import static java.lang.String.join;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.apache.commons.lang3.StringUtils.EMPTY;
import static org.apache.commons.lang3.StringUtils.prependIfMissing;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessRequest;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.preprocessResponse;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.prettyPrint;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@Log4j
@UtilityClass
public class TestUtils {
    private static final String ASCIIDOC_ROOT = "target/classes/asciidoc";
	private static final Logger log = LoggerFactory.getLogger(TestUtils.class);

    public static JUnitRestDocumentation initRestDocuments() {
        return new JUnitRestDocumentation(join(EMPTY, ASCIIDOC_ROOT, prependIfMissing("api/payments", "/")));
    }

    public static MockMvc initMockMvc(final WebApplicationContext context,
                                      final RestDocumentationContextProvider contextProvider) {
        return webAppContextSetup(context)
                .apply(documentationConfiguration(contextProvider))
                .alwaysDo(document("{method-name}",
                        preprocessRequest(prettyPrint()),
                        preprocessResponse(prettyPrint())))
                .build();
    }

    public static String readJsonFile(final String path) {
        try {
            return readLines(new ClassPathResource(path).getFile(), UTF_8)
                    .stream()
                    .collect(Collectors.joining());
        } catch (final IOException exception) {
            log.error(String.format("Unable to access %s", path), exception);

            return EMPTY;
        }
    }
}
