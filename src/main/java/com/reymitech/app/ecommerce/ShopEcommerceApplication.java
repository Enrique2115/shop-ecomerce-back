package com.reymitech.app.ecommerce;

import com.reymitech.app.ecommerce.utils.config.CorsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ShopEcommerceApplication {

    @Bean
    public CorsConfig corsConfig() {
        return new CorsConfig();
    }

    public static void main(String[] args) {
        SpringApplication.run(ShopEcommerceApplication.class, args);
    }

}
