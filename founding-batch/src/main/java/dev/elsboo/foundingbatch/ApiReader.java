package dev.elsboo.foundingbatch;

import dev.elsboo.coupang.BestCategoryRequest;
import dev.elsboo.coupang.BestCategoryResponse;
import dev.elsboo.coupang.Category;
import dev.elsboo.coupang.CoupangClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@RequiredArgsConstructor
@Slf4j
public class ApiReader implements ItemReader<BestCategoryResponse> {

    private final static BestCategoryResponse NO_DATA = null;
    private final AtomicInteger index = new AtomicInteger();
    private final Category[] categories = Category.values();
    private final CoupangClient coupangclient;
    private boolean first = true;

    @Override
    public BestCategoryResponse read() throws InterruptedException {
        log.info("[Reader] read start");

        // API 호출 제한 떄문에 쉼 필요
        sleep(8);

        log.info("count: {}, categories: {}", index.get(), categories.length);
        if (index.get() >= categories.length) {
            return NO_DATA;
        }

        BestCategoryRequest request = new BestCategoryRequest();
        BestCategoryResponse bestCategoryResponse = coupangclient.getBestCategories(
            categories[index.get()].getCategoryId(),
            request.getLimit(),
            request.getSubId()
        );

/*        BestCategoryResponse bestCategoryResponse = BestCategoryResponse.builder()
            .data(singletonList(
                BestCategoryResponse.Product.builder()
                    .categoryName(categories[index.get()].getCategoryName())
                    .build())
            )
            .build();*/

        index.incrementAndGet();

        log.info("[Reader] read finished: {}", bestCategoryResponse);
        return bestCategoryResponse;
    }

    private void sleep(int minute) throws InterruptedException {
        if (first) {
            first = false;
        } else {
            log.info("sleep for {} minutes start.", minute);
            Thread.sleep(Duration.ofMinutes(minute).toMillis());
            log.info("sleep for {} minutes finished.", minute);
        }
    }
}
