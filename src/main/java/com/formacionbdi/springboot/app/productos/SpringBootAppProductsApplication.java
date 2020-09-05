package com.formacionbdi.springboot.app.productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;


@EntityScan({"com.formacionbdi.springboot.app.models.entity"})
@EnableEurekaClient
@SpringBootApplication
public class SpringBootAppProductsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAppProductsApplication.class, args);
    }

}
