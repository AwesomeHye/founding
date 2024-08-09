package dev.elsboo.coupang;

import lombok.Getter;

@Getter
public class BestCategoryRequest {

    private Integer limit;
    private String subId;
    private String imageSize;

    public BestCategoryRequest() {
        this.limit = 100;
        this.subId = "AF8715550";
    }
}
