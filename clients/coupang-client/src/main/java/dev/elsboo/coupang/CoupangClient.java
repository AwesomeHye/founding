package dev.elsboo.coupang;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "coupang", url = "${client.domain}", configuration = CoupangClientConfiguration.class)
public interface CoupangClient {

    @GetMapping("${client.base-url}/products/bestcategories/{categoryId}")
    BestCategoryResponse getBestCategories(@PathVariable("categoryId") Integer categoryId);
}
