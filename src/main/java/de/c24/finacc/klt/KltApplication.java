package de.c24.finacc.klt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class KltApplication {

    public static void main(String[] args) {
        SpringApplication.run(KltApplication.class, args);
    }
}
