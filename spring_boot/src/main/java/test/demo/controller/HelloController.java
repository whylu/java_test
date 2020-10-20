package test.demo.controller;



import ming.demo.MingHelloTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import test.demo.DemoApplication;


@SpringBootApplication
//    |- @org.springframework.context.annotation.Configuration
//    |- @org.springframework.context.annotation.ComponentScan
//    `- @org.springframework.boot.autoconfigure.EnableAutoConfiguration

@RestController
public class HelloController {
    public static void main(String[] args) {
        SpringApplication.run(HelloController.class, args);
    }
    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name) {
        return "hello, " + name;
    }

}
