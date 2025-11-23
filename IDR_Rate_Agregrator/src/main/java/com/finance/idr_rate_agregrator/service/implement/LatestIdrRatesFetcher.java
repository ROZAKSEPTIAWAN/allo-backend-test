package com.finance.idr_rate_agregrator.service.implement;

import com.finance.idr_rate_agregrator.dto.LatestRatesResponse;
import com.finance.idr_rate_agregrator.service.IDRDataFetcher;
import com.finance.idr_rate_agregrator.util.SpreadCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service("latest_idr_rates")
public class LatestIdrRatesFetcher implements IDRDataFetcher {

    private final WebClient webClient;

    private final SpreadCalculator calculator;

    public LatestIdrRatesFetcher(@Qualifier("frankfurterWebClient") WebClient webClient, SpreadCalculator calculator) {
        this.webClient = webClient;
        this.calculator = calculator;
    }


    @Override
    public Object fetchData() {

        LatestRatesResponse result = webClient
                .get()
                .uri("/latest?base=IDR")
                .retrieve()
                .bodyToMono(LatestRatesResponse.class)
                .block();


        return result;
    }
}
