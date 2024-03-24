package com.TYR.MainPackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.time.LocalTime;
import java.util.TimeZone;

@SpringBootApplication
public class MainClass {
    @Value("${app.variable.database-url}")
    private static String databaseUrl;
    @Value("${app.variable.database-username}")
    private static String databaseUsername;
    @Value("${app.variable.database-password}")
    private static String databasePassword;

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
        System.out.println(databaseUrl + databaseUsername + databasePassword);
    }
}