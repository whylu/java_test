package test.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//    |- @org.springframework.context.annotation.Configuration
//    |- @org.springframework.context.annotation.ComponentScan
//    `- @org.springframework.boot.autoconfigure.EnableAutoConfiguration
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}



