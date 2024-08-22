package dev.elsboo.foundingdisplay.service;

import dev.elsboo.foundingdisplay.r2dbc.CoupangR2Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class BestCategoryService {

    private final CoupangR2Repository coupangR2Repository;

    public Flux<Map<String, Object>> findAll() {
        Flux<Map<String, Object>> all = coupangR2Repository.findAll();
        return all;
    }

}
