package com.finance.idr_rate_agregrator.client;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
@EnableConfigurationProperties(FrankfurterApiProperties.class)
public class FrankfurterClientConfig {

    @Bean
    public FrankfurterClientFactory frankfurterClientFactory(FrankfurterApiProperties props) {
        return new FrankfurterClientFactory(props);
    }

    @Bean("frankfurterWebClient")
    public WebClient frankfurterWebClient(FrankfurterClientFactory factory) throws Exception {
        return factory.getObject();
    }

}
