package dev.elsboo.founding.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "coupang_product")
@Getter
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String categoryName;
    private Boolean isRocket;
    private Boolean isFreeShipping;
    private Integer productId;
    private String productImage;
    private String productName;
    private Integer productPrice;
    private String productUrl;
    private String timestamp;

    @Builder
    public Product(int id, String categoryName, Boolean isRocket, Boolean isFreeShipping, Integer productId, String productImage, String productName,
                   Integer productPrice, String productUrl, String timestamp) {
        this.id = id;
        this.categoryName = categoryName;
        this.isRocket = isRocket;
        this.isFreeShipping = isFreeShipping;
        this.productId = productId;
        this.productImage = productImage;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productUrl = productUrl;
        this.timestamp = LocalDateTime.now().toString();
    }
}