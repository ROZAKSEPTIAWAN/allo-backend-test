package com.finance.idr_rate_agregrator.client;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;



@Data
@ConfigurationProperties(prefix = "frankfurter.api")
public class FrankfurterApiProperties
{


    private String BASE_URL;

}
