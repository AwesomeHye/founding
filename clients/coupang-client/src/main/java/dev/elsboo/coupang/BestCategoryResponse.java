package dev.elsboo.coupang;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collections;
import java.util.List;

@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Builder
public class BestCategoryResponse {

    public static final BestCategoryResponse EMPTY = BestCategoryResponse.builder().data(Collections.emptyList()).build();

    private String rCode;
    private String rMessage;
    private List<Product> data;

    @Getter
    @NoArgsConstructor
    @ToString
    public static class Product {

        private String categoryName;
        private Boolean isRocket; // 로켓 배송 상품 여부
        private Boolean isFreeShipping; // 무료 배송 여부
        private Long productId;
        private String productImage;
        private String productName;
        private Long productPrice;
        private String productUrl;
    }
}
