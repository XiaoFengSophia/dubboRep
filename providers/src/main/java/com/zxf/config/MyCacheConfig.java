package com.zxf.config;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @Author: zhaoxiaofeng
 * @Description:
 * @Date: 2020/12/26 13:37
 */
@Configuration
public class MyCacheConfig {

    @Bean("myKeyGenerator")
    public KeyGenerator myKeyGenerator(){
        return new KeyGenerator(){

            @Override
            public Object generate(Object target, Method method, Object... params) {
                System.out.println(method.getName() + "[" + Arrays.asList(params).toString() + "]");
                return method.getName() + "[" + Arrays.asList(params).toString() + "]";
            }
        };

    }
}
