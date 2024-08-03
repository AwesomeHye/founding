package dev.elsboo.coupang;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class BestCategoryRequest {

    private Integer categoryId;
    private Integer limit;
    private String subId;
    private String imageSize;
}
