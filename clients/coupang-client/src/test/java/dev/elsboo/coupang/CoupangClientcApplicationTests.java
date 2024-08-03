package dev.elsboo.coupang;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class CoupangClientcApplicationTests {

    @Autowired
    CoupangClient coupangClient;

    @Test
    void contextLoads() {
        BestCategoryResponse bestCategories = coupangClient.getBestCategories(Category.WOMAN_FASHION.getCategoryId());
        log.info("{}", bestCategories);
    }

}
