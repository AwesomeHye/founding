package dev.elsboo.founding.client;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CoupangBestCategoryResponse {

    private String rCode;
    private String rMessage;
    private List<Product> data;

    @Getter
    @AllArgsConstructor
    public static class Product {

        private String categoryName;
        private Boolean isRocket; // 로켓 배송 상품 여부
        private Boolean isFreeShipping; // 무료 배송 여부
        private Integer productId;
        private String productImage;
        private String productName;
        private String productPrice;
        private String productUrl;
    }
}
