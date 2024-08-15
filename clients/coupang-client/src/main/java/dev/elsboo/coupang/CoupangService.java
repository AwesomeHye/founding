package dev.elsboo.coupang;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@RequiredArgsConstructor
public class CoupangService {

    private final CoupangClient coupangClient;

    public BestCategoryResponse getBestCategories(Integer categoryId, BestCategoryRequest request) {

        return coupangClient.getBestCategories(categoryId, request);
    }

    @FeignClient(name = "coupangClient", url = "${client.domain}", configuration = CoupangClientConfiguration.class)
    public interface CoupangClient {

        @GetMapping(path = "${client.base-url}/products/bestcategories/{categoryId}", produces = "application/json")
        BestCategoryResponse getBestCategories(@PathVariable("categoryId") Integer categoryId, @RequestParam("request") BestCategoryRequest request);
    }

}
