package com.zh.boot_activemq_produce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableJms
@EnableScheduling
public class BootActivemqProduceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootActivemqProduceApplication.class, args);
    }

}
