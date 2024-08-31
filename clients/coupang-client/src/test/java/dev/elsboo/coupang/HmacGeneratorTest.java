package dev.elsboo.coupang;

import dev.elsboo.coupang.auth.HmacGenerator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class HmacGeneratorTest {

    private final static String REQUEST_METHOD = "GET";
    private final static String URL = "/v2/providers/affiliate_open_api/apis/openapi/v1/products/bestcategories/1002?limit=50";

    @Value("${coupang.access-key}")
    private String accessKey;
    @Value("${coupang.secret-key}")
    private String secretKey;

    @Test
    void generateHmac() {
//        String REQUEST_METHOD = "POST";
//        String URL = "/v2/providers/affiliate_open_api/apis/openapi/v1/deeplink";
        String key = HmacGenerator.generate(REQUEST_METHOD, URL, secretKey, accessKey);
        log.info(key);
    }
}
