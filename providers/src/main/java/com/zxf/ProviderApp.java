package com.zxf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;
//@EnableDubbo
@SpringBootApplication
@ImportResource({"classpath:dubbo-provider.xml"})
@EnableCaching
public class ProviderApp {
	public static void main(String[] args) {
        SpringApplication.run(ProviderApp.class, args);
    }

}
