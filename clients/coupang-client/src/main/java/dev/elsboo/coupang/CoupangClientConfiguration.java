package dev.elsboo.coupang;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoupangClientConfiguration {

    @Bean
    public AuthorizationInterceptor authrorizationInterceptor() {
        return new AuthorizationInterceptor();
    }

}
