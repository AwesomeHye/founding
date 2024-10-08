package dev.elsboo.foundingdisplay.r2dbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

@SpringBootTest
class CoupangR2RepositoryTest {

    @Autowired
    private CoupangR2Repository coupangR2Repository;

    @Test
    void findAll() {
        coupangR2Repository.findAll()
            .doOnNext(System.out::println)
            .blockLast();
    }

    @Test
    void findById() {
        Map<String, Object> result = coupangR2Repository.findById(1).blockFirst();
        System.out.println(result);
    }

}
