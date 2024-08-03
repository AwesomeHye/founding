package dev.elsboo.coupang;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "coupang", url = "https://api-gateway.coupang.com", configuration = CoupangClientConfiguration.class)
public interface CoupangClient {

    @GetMapping("/v2/providers/affiliate_open_api/apis/openapi/v1/products/bestcategories/{categoryId}")
    BestCategoryResponse getBestCategories(@PathVariable("categoryId") Integer categoryId);
}
