package dev.elsboo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@Slf4j
public class FoundingDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoundingDbApplication.class, args);
    }

}
