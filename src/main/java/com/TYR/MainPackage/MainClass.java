package com.TYR.MainPackage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalTime;
import java.util.TimeZone;

@SpringBootApplication
public class MainClass {
    public static void main(String[] args) {
        SpringApplication.run(MainClass.class, args);
        System.out.println(LocalTime.now());
        System.out.println(TimeZone.getDefault().getID());

        // Docs for env
        // https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.external-config
        // References
        // https://stackoverflow.com/questions/35531661/using-env-variable-in-spring-boots-application-properties
        // Ideas
        // https://github.com/topics/loyalty-program?l=java
    }
}