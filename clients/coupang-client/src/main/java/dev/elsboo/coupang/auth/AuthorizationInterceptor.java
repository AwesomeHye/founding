package dev.elsboo.coupang.auth;


import feign.RequestInterceptor;
import feign.RequestTemplate;

public class AuthorizationInterceptor implements RequestInterceptor {

    private final String accessKey;
    private final String secretKey;

    public AuthorizationInterceptor(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("Authorization", HmacGenerator.generate(requestTemplate.method(), requestTemplate.url(), secretKey, accessKey));
    }
}
