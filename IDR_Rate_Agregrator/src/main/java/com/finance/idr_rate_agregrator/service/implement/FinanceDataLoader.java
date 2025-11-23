package com.finance.idr_rate_agregrator.service.implement;


import com.finance.idr_rate_agregrator.service.IDRDataFetcher;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class FinanceDataLoader implements ApplicationRunner {

    private final Map<String, IDRDataFetcher> strategies;
    private final FinanceDataStore store;

    public FinanceDataLoader(Map<String, IDRDataFetcher> strategies, FinanceDataStore store) {
        this.strategies = strategies;
        this.store = store;
    }

    @Override
    public void run(org.springframework.boot.ApplicationArguments args) {
        strategies.forEach((key, fetcher) -> {
            Object data = fetcher.fetchData();
            store.put(key, data);
        });
    }
}
