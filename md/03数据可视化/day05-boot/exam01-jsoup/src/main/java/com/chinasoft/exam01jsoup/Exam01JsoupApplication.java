package com.chinasoft.exam01jsoup;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Exam01JsoupApplication {

    public static void main(String[] args) {
        SpringApplication.run(Exam01JsoupApplication.class, args);
    }

    @Bean
    public ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }


}
