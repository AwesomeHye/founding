package dev.elsboo.foundingbatch;


import dev.elsboo.coupang.BestCategoryResponse;
import dev.elsboo.foundingdb.Product;
import org.springframework.batch.item.ItemProcessor;

import java.util.List;

public class ApiToDbProcessor implements ItemProcessor<BestCategoryResponse, List<Product>> {

    @Override
    public List<Product> process(BestCategoryResponse categoryResponses) {
        List<BestCategoryResponse.Product> items = categoryResponses.getData();

        return items.stream()
            .map(item -> Product.builder()
                .categoryName(item.getCategoryName())
                .isRocket(item.getIsRocket())
                .isFreeShipping(item.getIsFreeShipping())
                .productId(item.getProductId())
                .productImage(item.getProductImage())
                .productName(item.getProductName())
                .productPrice(item.getProductPrice())
                .productUrl(item.getProductUrl())
                .build())
            .toList();
    }
}
