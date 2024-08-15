package dev.elsboo.foundingdisplay.r2dbc;

import io.r2dbc.spi.ConnectionFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.Map;

@Component
@RequiredArgsConstructor
@Slf4j
public class CoupangR2Repository {

    private final ConnectionFactory connectionFactory;
    private final DatabaseClient databaseClient;
    private final R2dbcEntityTemplate r2dbcEntityTemplate;

    public Flux<Map<String, Object>> findAll() {
        return databaseClient.sql("SELECT * FROM coupang")
            .fetch()
            .all()
            .switchIfEmpty(Flux.empty())
            .doOnError(e -> log.error(e.getMessage()));
    }

    public Flux<Map<String, Object>> findById(Integer id) {
        return databaseClient.sql("SELECT * FROM coupang WHERE id = :id")
            .bind("id", id)
            .fetch()
            .all();
    }
}
