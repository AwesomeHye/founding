package dev.elsboo.coupang;

import dev.elsboo.coupang.auth.CoupangClientConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "coupangClient", url = "${client.domain}", configuration = CoupangClientConfiguration.class)
public interface CoupangClient {

    @GetMapping(path = "${client.base-url}/products/bestcategories/{categoryId}", produces = "application/json")
    BestCategoryResponse getBestCategories(@PathVariable("categoryId") Integer categoryId, @RequestParam("limit") Integer limit,
                                           @RequestParam("subId") String subId);

}
