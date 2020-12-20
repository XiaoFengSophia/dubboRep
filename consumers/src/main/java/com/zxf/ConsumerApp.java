package com.zxf;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
//@EnableDubbo
@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
@ImportResource({"classpath:dubbo-consumer.xml"})
public class ConsumerApp{
	public static void main(String[] args) {
        SpringApplication.run(ConsumerApp.class, args);
    }

}
