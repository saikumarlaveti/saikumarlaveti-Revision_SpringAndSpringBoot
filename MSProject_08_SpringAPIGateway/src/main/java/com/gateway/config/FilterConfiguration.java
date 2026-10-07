package com.gateway.config;



import org.springframework.cloud.gateway.server.mvc.filter.SimpleFilterSupplier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gateway.filter.CustomGatewayFilters;

@Configuration
public class FilterConfiguration {

    @Bean
    public SimpleFilterSupplier customGatewayFilterSupplier() {

        return new SimpleFilterSupplier(
                CustomGatewayFilters.class
        );
    }
}
