package com.zxf.service;

import com.zxf.entities.Emp;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

/**
 * @Author: zhaoxiaofeng
 * @Description:
 * @Date: 2020/12/19 16:04
 */
public interface IEhcacheService {

    List<Emp> queryAllEmp();
}
