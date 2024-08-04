package dev.elsboo;

import dev.elsboo.coupang.CoupangClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CoupangClientApplication {

    @Autowired
    CoupangClient coupangClient;

    public static void main(String[] args) {
        SpringApplication.run(CoupangClientApplication.class, args);
    }

}
