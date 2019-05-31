package com.example.process.configuration;

import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.PingUrl;
import org.springframework.context.annotation.Bean;

public class RibbonConfiguration {

    /**
     * A interface “IPing” define a maneira com que o Ribbon realizará a checagem das instâncias que estão ativas, nesse caso,
     * estamos definindo que isso não será realizado através da classe NoOpPing. Já a interface “IRule” é usada para definir
     * qual regra o Ribbon utilizará para distribuir a carga, neste exemplo utilizaremos a estratégia Round Robin
     * (vide “O que é Load Balancing?”) através da classe “RoundRobinRule”.
     */
    @Bean
    public IPing ribbonPing() {
        return new PingUrl();
    }

//    @Bean
//    public IRule ribbonRule() {
//        return new BestAvailableRule();
//    }

//    @Bean
//    public IRule ribbonRule() {
//        return new RoundRobinRule();
//    }

//    public IRule ribbonRule() {
//        return new WeightedResponseTimeRule();
//    }

}
