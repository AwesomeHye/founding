package dev.elsboo.founding.client.coupang;

import org.junit.jupiter.api.Test;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductClientTest {

    @Test
    void uriTest() {
        URI uri = UriComponentsBuilder
            .fromHttpUrl("http://localhost:8080")
            .path("/products/bestcategories")
            .queryParam("categoryId", 1001)
            .build().toUri();

        assertEquals("http://localhost:8080/products/bestcategories?categoryId=1001", uri.toString());
    }

}
