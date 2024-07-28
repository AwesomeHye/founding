package dev.elsboo.founding.client;

import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;

@Component
public class CoupangClient {

    public CoupangBestCategoryResponse getCategoryBestProducts(CoupangBestCategoryRequest request) {
        URI uri = null;
        try {
            uri = new URI("/best");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        HttpRequest httpRequest = HttpRequest.newBuilder(uri).build();
        return null;
    }

}
