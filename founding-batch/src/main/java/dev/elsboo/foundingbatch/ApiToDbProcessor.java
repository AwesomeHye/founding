package dev.elsboo.foundingbatch;

import dev.elsboo.founding.client.coupang.BestCategoryResponse;
import dev.elsboo.founding.db.Product;
import org.springframework.batch.item.ItemProcessor;

import java.util.List;

public class ApiToDbProcessor implements ItemProcessor<List<BestCategoryResponse>, List<Product>> {

    @Override
    public List<Product> process(List<BestCategoryResponse> categoryResponses) {
        return categoryResponses.stream().flatMap(response -> response.getData().stream())
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
