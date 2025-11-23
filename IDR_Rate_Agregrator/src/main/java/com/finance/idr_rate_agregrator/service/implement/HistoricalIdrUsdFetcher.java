package com.finance.idr_rate_agregrator.service.implement;

import com.finance.idr_rate_agregrator.service.IDRDataFetcher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


@Service("historical_idr_usd")
public class HistoricalIdrUsdFetcher implements IDRDataFetcher {

    private final WebClient webClient;

    public HistoricalIdrUsdFetcher(@Qualifier("frankfurterWebClient") WebClient webClient) {
        this.webClient = webClient;
    }


    @Override
    public Object fetchData() {
        return webClient.get()
                .uri("/2024-01-01..2024-01-05?from=IDR&to=USD")
                .retrieve()
                .bodyToMono(Object.class) // atau HistoricalRatesResponse kalau sudah buat DTO
                .block();
    }
}
