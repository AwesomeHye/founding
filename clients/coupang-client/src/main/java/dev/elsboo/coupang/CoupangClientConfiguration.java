package dev.elsboo.coupang;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoupangClientConfiguration {

    @Value("${coupang.access-key}")
    private String accessKey;

    @Value("${coupang.secret-key}")
    private String secretKey;

    @Bean
    public AuthorizationInterceptor authorizationInterceptor() {
        return new AuthorizationInterceptor(accessKey, secretKey);
    }

}
