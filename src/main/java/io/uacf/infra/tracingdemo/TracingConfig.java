package io.uacf.infra.tracingdemo;

import io.opentracing.Tracer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TracingConfig {
    private static Logger log = LoggerFactory.getLogger(TracingConfig.class.getName());

    @Bean
    public Tracer lightstepTracer(@Value("${tracing.lightstep.access_token}") String accessToken) throws Exception {
        log.info("Using access token: {}", accessToken);

        return new com.lightstep.tracer.jre.JRETracer(
                new com.lightstep.tracer.shared.Options.OptionsBuilder()
                        .withComponentName("identity")
                        .withAccessToken(accessToken)
                        .withVerbosity(4)
                        .build());
    }

}
