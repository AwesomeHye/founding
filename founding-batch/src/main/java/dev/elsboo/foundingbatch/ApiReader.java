package dev.elsboo.foundingbatch;

import dev.elsboo.coupang.BestCategoryResponse;
import dev.elsboo.coupang.Category;
import dev.elsboo.coupang.CoupangService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Collections.singletonList;

@Component
@RequiredArgsConstructor
@Slf4j
public class ApiReader implements ItemReader<BestCategoryResponse> {

    private final static BestCategoryResponse NO_DATA = null;
    private final AtomicInteger index = new AtomicInteger();
    private final Category[] categories = Category.values();
    private final CoupangService coupangService;
    private boolean first = true;

    @Override
    public BestCategoryResponse read() throws InterruptedException {
        log.info("read start");

        // API 호출 제한 떄문에 쉼 필요
        if (first) {
            first = false;
        } else {
            log.info("sleep");
            Thread.sleep(Duration.ofSeconds(2).toMillis());
        }

        log.info("count: {}, categories: {}", index.get(), categories.length);
        if (index.get() >= categories.length) {
            return NO_DATA;
        }

        /*BestCategoryResponse bestCategories = coupangService.getBestCategories(
            categories[count.get()].getCategoryId(),
            new BestCategoryRequest()
        );*/

        BestCategoryResponse bestCategories = BestCategoryResponse.builder()
            .data(singletonList(
                BestCategoryResponse.Product.builder()
                    .categoryName(categories[index.get()].getCategoryName()).build()))
            .build();

        index.incrementAndGet();

        log.info("read finished");
        return bestCategories;
    }
}
