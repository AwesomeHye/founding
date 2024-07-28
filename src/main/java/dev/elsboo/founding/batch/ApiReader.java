package dev.elsboo.founding.batch;

import dev.elsboo.founding.client.CoupangClient;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApiReader implements ItemReader<String> {

    private final CoupangClient coupangClient;
    private int count = 0;

    @Override
    public String read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        if (count < 3) {
            count++;
            return "A";
        }

        // null 을 반환하면 읽기를 멈춤
        return null;
    }
}
