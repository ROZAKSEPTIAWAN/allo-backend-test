IDR Rate Aggregator is a Spring Boot application that exposes one REST API endpoint for aggregating three different datasets from the Frankfurter Exchange Rate API.

This project demonstrates:

Strategy Pattern
FactoryBean-based WebClient configuration
ApplicationRunner-based startup data ingestion
Thread-safe and immutable in-memory caching
Clean architecture and production-ready structure
This project is built as part of the Backend Developer Take-Home Test for Allo Bank.

src/main/java/com/finance/idr_rate_aggregator
├── controller/
│   └── FinanceController.java
│
├── client/
│   ├── FrankfurterClientConfig.java
│   ├── FrankfurterClientFactory.java
│   └── FrankfurterApiProperties.java
│
├── service/
│   ├── IDRDataFetcher.java
│   ├── LatestIdrRatesFetcher.java
│   ├── HistoricalIdrUsdFetcher.java
│   ├── SupportedCurrenciesFetcher.java
│   ├── FinanceDataStore.java
│   └── FinanceDataLoader.java
│
├── dto/
│   ├── LatestRatesResponse.java
│   ├── HistoricalRatesResponse.java
│   ├── LatestRatesWithSpread.java
│   └── CurrencyListResponse.java
│
├── util/
│   └── SpreadCalculator.java
│
└── exception/
├── GlobalExceptionHandler.java
└── ResourceNotFoundException.java

How to Run the Application
1. git clone https://github.com/<your-username>/IDR_Rate_Aggregator.git
   cd IDR_Rate_Aggregator
2. mvn clean install
3. mvn spring-boot:run
4. java -jar target/idr-rate-aggregator.jar

API Endpoint
curl -X GET http://localhost:8080/api/finance/data/latest_idr_rates
curl -X GET http://localhost:8080/api/finance/data/historical_idr_usd
curl -X GET http://localhost:8080/api/finance/data/supported_currencies

Spread Factor
rozakseptiawan
r=114
o=111
z=122
a=97
k=107
s=115
e=101
p=112
t=116
i=105
a=97
w=119
a=97
n=110
-------------------------
TOTAL = 1523

spread = (1523 % 1000) / 100000.0
spread = 523 / 100000
spread = 0.00523

