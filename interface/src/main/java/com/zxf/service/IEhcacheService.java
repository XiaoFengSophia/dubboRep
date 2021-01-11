package com.zxf.service;

import com.zxf.entities.Emp;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Map;

/**
 * @Author: zhaoxiaofeng
 * @Description:
 * @Date: 2020/12/19 16:04
 */
public interface IEhcacheService {

    List<Emp> queryAllEmp();

    Integer updateByEmpNo(Map<String, Object> paramMap);

    List<Emp> queryByEmpNo(Map<String, Object> paramMap);

    Integer deleteByEmpNo(Map<String, Object> paramMap);
}
