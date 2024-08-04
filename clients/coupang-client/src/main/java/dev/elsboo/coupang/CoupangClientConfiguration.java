package dev.elsboo.coupang;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoupangClientConfiguration {

//    public final static String ACCESS_KEY = "b175c434-d7bd-4015-a3bf-0bb8e96bf256";
//    public final static String SECRET_KEY = "99d6c3c1a829fd9a172ce7073c8e1c348115b823";

    @Value("${coupang.access-key}")
    private String accessKey;

    @Value("${coupang.secret-key}")
    private String secretKey;

    @Bean
    public AuthorizationInterceptor authorizationInterceptor() {
        return new AuthorizationInterceptor(accessKey, secretKey);
    }

}
