package dev.elsboo.founding;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class FoundingApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoundingApplication.class, args);
    }

}
