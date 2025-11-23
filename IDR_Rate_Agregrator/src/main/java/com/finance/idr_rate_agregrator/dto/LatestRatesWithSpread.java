package com.finance.idr_rate_agregrator.dto;

public record LatestRatesWithSpread(LatestRatesResponse origin, double UsdSpreadIdr) {
}
