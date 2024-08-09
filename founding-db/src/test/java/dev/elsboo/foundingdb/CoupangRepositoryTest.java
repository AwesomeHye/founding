package dev.elsboo.foundingdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CoupangRepositoryTest {

    @Autowired
    CoupangRepository coupangRepository;

    @org.junit.jupiter.api.Test
    void test() {
        Product product = Product.builder()
            .categoryName("test")
            .productImage("test")
            .productName("test")
            .productUrl("test")
            .build();
    }
}
