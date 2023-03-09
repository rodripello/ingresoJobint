package com.jobint.ingresoJobintApi.Configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.rootUri("some uri")
                .additionalInterceptors((ClientHttpRequestInterceptor) (request, body, execution) -> {
                    request.getHeaders().add("Content-Type","application/json");
                    request.getHeaders().add("Authorization", "fsq3Ir23vMOcIPYW+RnueX744WIVZJWtmEmv+GkKcrgCRfQ=");
                    return execution.execute(request, body);
                }).build();
    }
}
