package dev.elsboo.founding.batch;

import dev.elsboo.founding.db.Coupang;
import dev.elsboo.founding.db.CoupangRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class DbWriter implements ItemWriter<String> {

    private final CoupangRepository coupangRepository;

    @Override
    public void write(Chunk<? extends String> chunk) throws Exception {
        List<Coupang> coupangs = convert(chunk);
        coupangRepository.saveAll(coupangs);
        log.info("Write chunk: {}", chunk.getItems());
    }

    private List<Coupang> convert(Chunk<? extends String> chunk) {
        return chunk.getItems().stream()
            .map(item -> Coupang.builder().memo(item).build())
            .collect(Collectors.toList());
    }
}
