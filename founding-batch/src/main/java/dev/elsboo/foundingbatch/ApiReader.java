package dev.elsboo.foundingbatch;

import dev.elsboo.coupang.BestCategoryResponse;
import dev.elsboo.coupang.Category;
import dev.elsboo.coupang.CoupangService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Collections.singletonList;

@Component
@RequiredArgsConstructor
@Slf4j
public class ApiReader implements ItemReader<List<BestCategoryResponse>> {

    private final CoupangService coupangService;
    private final AtomicInteger count = new AtomicInteger(0);
    private boolean terminate = false;

    @Override
    public List<BestCategoryResponse> read() {
        log.info("read start");
        List<BestCategoryResponse> bestCategoryResponses = Arrays.stream(Category.values())
            .map(category -> {
                    count.incrementAndGet();
                    log.info("category: {}", category);
                    return BestCategoryResponse.builder()
                        .data(singletonList(BestCategoryResponse.Product.builder()
                            .categoryName(category.getCategoryName().concat(" " + count.get())).build()))
                        .build();
                }

                /*coupangService.getBestCategories(
                    category.getCategoryId(),
                    new BestCategoryRequest()
                )*/ // 분당 횟수 초과 제한 걸림. 방어로직 필요
            ).toList();
        log.info("read finished");

        if (!terminate) {
            log.info("count finished: {}", count.get());
            terminate = true;
            return bestCategoryResponses;
        }
        // null 을 반환하면 reader 를 멈춤
        return null;
    }
}
