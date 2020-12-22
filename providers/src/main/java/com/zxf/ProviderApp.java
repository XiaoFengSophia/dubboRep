package com.zxf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

//@EnableDubbo
@SpringBootApplication
@ImportResource({"classpath:dubbo-provider.xml"})
@PropertySource(value={"classpath:jdbc.properties","classpath:dubbo.properties"})
@EnableCaching
public class ProviderApp {
	public static void main(String[] args) {
        SpringApplication.run(ProviderApp.class, args);
    }

}
