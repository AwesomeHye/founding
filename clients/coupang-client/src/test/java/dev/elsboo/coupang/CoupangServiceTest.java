package dev.elsboo.coupang;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CoupangServiceTest {

    @Autowired
    private CoupangService coupangService;

    @Test
    void getBestCategories() {
        BestCategoryRequest request = new BestCategoryRequest();
        BestCategoryResponse bestCategories = coupangService.getBestCategories(1001, request);

        assertNotNull(bestCategories);
        assertNotNull(bestCategories.getData());
        System.out.println(bestCategories);
    }

}
