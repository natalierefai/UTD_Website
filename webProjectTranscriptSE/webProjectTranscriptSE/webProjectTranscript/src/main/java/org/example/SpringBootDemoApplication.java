package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ResourceLoader;

@SpringBootApplication
public class
SpringBootDemoApplication {

    public static void main(String[] args) {
        ApplicationContext context =  SpringApplication.run(SpringBootDemoApplication.class, args);


        Service service = context.getBean(Service.class);

    }

    @Bean
    public Service service(ResourceLoader resourceLoader) {
        return new Service(resourceLoader);
    }
}