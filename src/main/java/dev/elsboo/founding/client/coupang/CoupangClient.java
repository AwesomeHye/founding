package dev.elsboo.founding.client.coupang;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Component
@RequiredArgsConstructor
public class CoupangClient {

    private final HttpClient client = HttpClient.newHttpClient(); // 재사용 가능. immutable and thread-safe
    private final ObjectMapper objectMapper;

    @Value("${client.coupang-base-url}")
    private String baseUrl;

    public BestCategoryResponse getCategoryBestProducts(BestCategoryRequest request) {
        HttpRequest httpRequest = HttpRequest.newBuilder(getBestCategoriesUri(request)).GET().build();

        HttpResponse<BestCategoryResponse> httpResponse = null;
        try {
            httpResponse = client.send(httpRequest, re -> HttpResponse.BodySubscribers.mapping(
                HttpResponse.BodySubscribers.ofInputStream(),
                inputStream -> {
                    try (InputStream is = inputStream) {
                        return objectMapper.readValue(is, BestCategoryResponse.class);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            ));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        return httpResponse.body();
    }

    private URI getBestCategoriesUri(BestCategoryRequest request) {
        return UriComponentsBuilder
            .fromHttpUrl(baseUrl)
            .path("/products/bestcategories")
            .queryParam("categoryId", request.getCategoryId())
            .queryParam("limit", request.getLimit())
            .queryParam("subId", request.getSubId())
            .queryParam("imageSize", request.getImageSize())
            .build().toUri();
    }

}
