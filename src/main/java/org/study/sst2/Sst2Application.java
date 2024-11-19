package org.study.sst2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class Sst2Application {
    public static void main(String[] args) {
        SpringApplication.run(Sst2Application.class, args);
    }

}
