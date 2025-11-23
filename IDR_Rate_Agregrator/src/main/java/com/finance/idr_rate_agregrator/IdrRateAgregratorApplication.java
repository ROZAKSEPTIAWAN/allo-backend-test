package com.finance.idr_rate_agregrator;

import com.finance.idr_rate_agregrator.client.FrankfurterApiProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;


@EnableConfigurationProperties(FrankfurterApiProperties.class)
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class IdrRateAgregratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(IdrRateAgregratorApplication.class, args);
    }

}
