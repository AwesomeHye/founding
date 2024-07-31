package dev.elsboo.founding.client.coupang;

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
