package dev.elsboo.coupang;


import feign.RequestInterceptor;
import feign.RequestTemplate;

public class AuthorizationInterceptor implements RequestInterceptor {

    public final static String REQUEST_METHOD = "GET";
    public final static String URL = "/v2/providers/affiliate_open_api/apis/openapi/v1/products/bestcategories";
    public final static String ACCESS_KEY = "";
    public final static String SECRET_KEY = "";

    @Override
    public void apply(RequestTemplate requestTemplate) {
        requestTemplate.header("Authorization", HmacGenerator.generate(REQUEST_METHOD, URL, SECRET_KEY, ACCESS_KEY));
    }
}
