package com.finance.idr_rate_agregrator.dto;

import java.util.Map;

public record LatestRatesResponse(

        String amount,
        String base,
        String date,
        Map<String, Double> rates
)

{}
