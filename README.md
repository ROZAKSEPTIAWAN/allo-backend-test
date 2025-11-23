IDR Rate Aggregator
IDR Rate Aggregator is a Spring Boot application exposing a single REST API endpoint that
aggregates three different datasets from the public, keyless Frankfurter Exchange Rate API.
This project showcases:
- Strategy Pattern for polymorphic data fetchers
- FactoryBean-based WebClient configuration
- ApplicationRunner for startup data ingestion
- Thread-safe & immutable in-memory caching
- Clean, production-grade architecture
- Built for the Allo Bank Backend Developer Take-Home Test
------------------------------------------------------------
Project Structure
src/main/java/com/finance/idr_rate_aggregator
- controller/
- FinanceController.java
- client/
- FrankfurterClientConfig.java
- FrankfurterClientFactory.java
- FrankfurterApiProperties.java
- service/
- IDRDataFetcher.java
- LatestIdrRatesFetcher.java
- HistoricalIdrUsdFetcher.java
- SupportedCurrenciesFetcher.java
- FinanceDataStore.java
- FinanceDataLoader.java
- dto/
- LatestRatesResponse.java
- HistoricalRatesResponse.java
- LatestRatesWithSpread.java
- CurrencyListResponse.java
- util/
- SpreadCalculator.java
- exception/
- GlobalExceptionHandler.java
- ResourceNotFoundException.java
------------------------------------------------------------
How to Run the Application
1. Clone the Repository
   git clone https://github.com/ROZAKSEPTIAWAN/IDR_Rate_Aggregator.git
   cd IDR_Rate_Aggregator
2. Build the Application
   mvn clean install
3. Run with Spring Boot
   mvn spring-boot:run
4. Or Run the JAR
   java -jar target/idr-rate-aggregator.jar
------------------------------------------------------------
Available API Endpoints
1. Latest IDR Rates
   curl -X GET http://localhost:8080/api/finance/data/latest_idr_rates
2. Historical IDR → USD Rates
   curl -X GET "http://localhost:8080/api/finance/data/historical_idr_usd"
3. Supported Currencies
   curl -X GET http://localhost:8080/api/finance/data/supported_currencies
------------------------------------------------------------
Spread Factor Calculation
GitHub username: rozakseptiawan
ASCII Total = 1523
spread = (1523 % 1000) / 100000.0
spread = 523 / 100000
spread = 0.00523
------------------------------------------------------------
Architectural Rationale
Why Strategy Pattern?
- Each data source has different structures but needs uniform behavior.
- Enables clean polymorphism and easy extension.
  Why FactoryBean for WebClient?
- Allows configurable, reusable WebClient instances.
- Centralizes base URL and reactive configuration.
  Why ApplicationRunner instead of @PostConstruct?
- ApplicationRunner runs after the full Spring context is ready.
- More suitable for I/O operations like startup data ingestion