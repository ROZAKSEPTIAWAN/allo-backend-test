package com.finance.idr_rate_agregrator.client;

import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.web.reactive.function.client.WebClient;

public class FrankfurterClientFactory implements FactoryBean<WebClient> {
    private final FrankfurterApiProperties apiConfig;

    public FrankfurterClientFactory(FrankfurterApiProperties apiConfig) {
        this.apiConfig = apiConfig;
    }


    @Override
    public @Nullable WebClient getObject() throws Exception {
        return WebClient.builder().baseUrl(apiConfig.getBASE_URL()).build();
    }

    @Override
    public @Nullable Class<?> getObjectType() {
        return WebClient.class;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
