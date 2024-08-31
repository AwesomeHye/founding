package dev.elsboo.coupang;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BestCategoryRequest {

    private Integer limit;
    private String subId;
    private String imageSize;

    public BestCategoryRequest() {
        this.limit = 100;
        this.subId = "AF8715550";
    }
}
