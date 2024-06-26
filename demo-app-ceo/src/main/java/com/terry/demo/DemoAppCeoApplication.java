package com.terry.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.terry.demo")
@EnableJpaRepositories(basePackages = "com.terry.demo")
@EntityScan(basePackages = "com.terry.demo")
public class DemoAppCeoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoAppCeoApplication.class, args);
    }

}
