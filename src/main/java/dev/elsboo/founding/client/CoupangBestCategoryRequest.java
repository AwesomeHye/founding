package dev.elsboo.founding.client;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CoupangBestCategoryRequest {

    private Integer categoryId;
    private Integer limit;
    private String subId;
    private String imageSize;
}
