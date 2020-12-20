package com.zxf.controller;

import com.zxf.entities.Emp;
import com.zxf.service.IEhcacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @Author: zhaoxiaofeng
 * @Description:
 * @Date: 2020/12/19 16:14
 */
@RestController
@RequestMapping("dubboExample/ehcache")
public class EhcacheController {

    @Autowired
    private IEhcacheService ehcacheService;

    @GetMapping("/queryAllEmp")
    public List<Emp> queryAllEmp(){


        return ehcacheService.queryAllEmp();
    }
}
