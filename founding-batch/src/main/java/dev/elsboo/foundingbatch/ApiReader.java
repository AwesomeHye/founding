package dev.elsboo.foundingbatch;

import dev.elsboo.coupang.BestCategoryRequest;
import dev.elsboo.coupang.BestCategoryResponse;
import dev.elsboo.coupang.Category;
import dev.elsboo.coupang.CoupangClient;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ApiReader implements ItemReader<List<BestCategoryResponse>> {

    private final CoupangClient coupangClient;

    @Override
    public List<BestCategoryResponse> read() {

        List<BestCategoryResponse> bestCategoryResponses = Arrays.stream(Category.values())
            .map(category ->
                coupangClient.getCategoryBestProducts(BestCategoryRequest.builder()
                    .categoryId(category.getCategoryId())
                    .build())
            ).toList();

        // null 을 반환하면 읽기를 멈춤
        return bestCategoryResponses;
    }
}
