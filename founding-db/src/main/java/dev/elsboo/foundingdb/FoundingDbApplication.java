package dev.elsboo.foundingdb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class FoundingDbApplication {

    public static void main(String[] args) {
        log.info("D");
        SpringApplication.run(FoundingDbApplication.class, args);
    }

}
