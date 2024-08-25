package dev.elsboo.foundingbatch;

import dev.elsboo.coupang.BestCategoryResponse;
import dev.elsboo.coupang.Category;
import dev.elsboo.coupang.CoupangService;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@RequiredArgsConstructor
public class ApiReader implements ItemReader<List<BestCategoryResponse>> {

    private final CoupangService coupangService;
    private final AtomicInteger count = new AtomicInteger(0);

    @Override
    public List<BestCategoryResponse> read() {
        count.incrementAndGet();
        List<BestCategoryResponse> bestCategoryResponses = Arrays.stream(Category.values())
            .map(category -> BestCategoryResponse.EMPTY

                /*coupangService.getBestCategories(
                    category.getCategoryId(),
                    new BestCategoryRequest()
                )*/ // 분당 횟수 초과 제한 걸림. 방어로직 필요
            ).toList();

        if (count.get() > 5) {
            return null;
        }
        // null 을 반환하면 읽기를 멈춤
        return bestCategoryResponses;
    }
}
