package com.finance.idr_rate_agregrator.service.implement;

import com.finance.idr_rate_agregrator.service.IDRDataFetcher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Map;


@Service("supported_currencies")
public class SupportedCurrenciesFetcher implements IDRDataFetcher {

    private final WebClient webclient;

    public SupportedCurrenciesFetcher(@Qualifier("frankfurterWebClient")  WebClient webclient) {
        this.webclient = webclient;
    }

    @Override
    public Object fetchData() {
        return webclient.get()
                .uri("/currencies")
                .retrieve()
                .bodyToMono(Map.class)
                .block();
    }
}
