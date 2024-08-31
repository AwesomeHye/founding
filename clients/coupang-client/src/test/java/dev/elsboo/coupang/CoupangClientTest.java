package dev.elsboo.coupang;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CoupangClientTest {

    @Autowired
    private CoupangClient coupangclient;

    @Test
    void getBestCategories() {
        BestCategoryRequest request = new BestCategoryRequest();
        BestCategoryResponse bestCategories = coupangclient.getBestCategories(1001, request.getLimit(), request.getSubId());

        System.out.println(bestCategories);
        assertNotNull(bestCategories);
        assertNotNull(bestCategories.getData());
    }

}
