package com.finance.idr_rate_agregrator.dto;

import java.util.Map;

public record HistoricalRatesResponse(Map<String, Map<String,Double>> rates) {
}
