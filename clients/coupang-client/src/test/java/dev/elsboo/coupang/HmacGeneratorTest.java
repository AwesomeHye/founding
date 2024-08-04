package dev.elsboo.coupang;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
class HmacGeneratorTest {

    private final static String REQUEST_METHOD = "GET";
    private final static String URL = "/v2/providers/affiliate_open_api/apis/openapi/v1/products/bestcategories/1001?limit=50";
    private final static String ACCESS_KEY = "b175c434-d7bd-4015-a3bf-0bb8e96bf256";
    private final static String SECRET_KEY = "99d6c3c1a829fd9a172ce7073c8e1c348115b823";

    @Test
    void generateHmac() {
//        String REQUEST_METHOD = "POST";
//        String URL = "/v2/providers/affiliate_open_api/apis/openapi/v1/deeplink";
        String key = HmacGenerator.generate(REQUEST_METHOD, URL, SECRET_KEY, ACCESS_KEY);
        log.info(key);
    }
}
