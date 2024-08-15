package dev.elsboo.foundingbatch;

import dev.elsboo.coupang.BestCategoryRequest;
import dev.elsboo.coupang.BestCategoryResponse;
import dev.elsboo.coupang.Category;
import dev.elsboo.coupang.CoupangService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ApiReader implements ItemReader<List<BestCategoryResponse>> {

    private final CoupangService coupangService;

    @Override
    public List<BestCategoryResponse> read() {

        List<BestCategoryResponse> bestCategoryResponses = Arrays.stream(Category.values())
            .map(category ->
                coupangService.getBestCategories(
                    category.getCategoryId(),
                    new BestCategoryRequest()
                )
            ).toList();

        // null 을 반환하면 읽기를 멈춤
        return bestCategoryResponses;
    }
}
