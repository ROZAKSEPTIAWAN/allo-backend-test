package com.finance.idr_rate_agregrator.util;


import com.finance.idr_rate_agregrator.client.FrankfurterApiProperties;
import org.springframework.stereotype.Component;

@Component
public class SpreadCalculator {

    public double calculateSpread(String userGitHub)
    {
        String lowerCase = userGitHub.toLowerCase();
        int sum = 0;
        for (char c : lowerCase.toCharArray())
        {
            sum += Character.getNumericValue(c);
        }
        return (sum  % 1000) / 100000.0;
    }
}
