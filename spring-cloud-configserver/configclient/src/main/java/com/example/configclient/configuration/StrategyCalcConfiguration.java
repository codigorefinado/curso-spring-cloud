package com.example.configclient.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
@ConfigurationProperties
public class StrategyCalcConfiguration {

    @Value("${strategy.calc:X}")
    private String strategyCalc;

    public String getStrategyCalc() {
        return strategyCalc;
    }
}
