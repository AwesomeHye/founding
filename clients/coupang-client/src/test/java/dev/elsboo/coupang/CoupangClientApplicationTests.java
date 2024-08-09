package dev.elsboo.coupang;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class CoupangClientApplicationTests {

    private final ObjectMapper objectMapper;

    @Autowired
    CoupangClient coupangClient;

    public CoupangClientApplicationTests() {
        this.objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    @Test
    void getCoupangClientResponse() throws JsonProcessingException {
//        BestCategoryResponse bestCategories = coupangClient.getBestCategories(Category.WOMAN_FASHION.getCategoryId());
        BestCategoryResponse bestCategories = coupangClient.getBestCategories(Category.WOMAN_FASHION.getCategoryId(), new BestCategoryRequest());
        log.info("{}", objectMapper.writeValueAsString(bestCategories));
    }

}
