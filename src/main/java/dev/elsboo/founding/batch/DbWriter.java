package dev.elsboo.founding.batch;

import dev.elsboo.founding.db.CoupangRepository;
import dev.elsboo.founding.db.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class DbWriter implements ItemWriter<List<Product>> {

    private final CoupangRepository coupangRepository;


    @Override
    public void write(Chunk<? extends List<Product>> chunk) {
        List<? extends List<Product>> items = chunk.getItems();
        List<Product> products = items.stream().flatMap(Collection::stream).collect(Collectors.toList());
        coupangRepository.saveAll(products);
        log.info("Write chunk: {}", products);
    }
}
