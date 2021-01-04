package com.zxf.controller;

import com.zxf.entities.Emp;
import com.zxf.service.IEhcacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 查询所有
     * @return
     */
    @GetMapping("/queryAllEmp")
    public List<Emp> queryAllEmp(){

        return ehcacheService.queryAllEmp();
    }

    /**
     * 根据empNo查询
     * @return
     */
    @GetMapping("/queryByEmpNo")
    public List<Emp> queryByEmpNo(String empNo){

        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("empNo", empNo);

        return ehcacheService.queryByEmpNo(paramMap);
    }

    /**
     * 根据empNo更新
     * @return
     */
    @GetMapping("/updateByEmpNo")
    public Integer updateByEmpNo(Integer empNo, String job){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("empNo", empNo);
        paramMap.put("job", job);
        return ehcacheService.updateByEmpNo(paramMap);
    }

    /**
     * 根绝empNo删除
     * @param empNo
     * @param job
     * @return
     */
    @GetMapping("/deleteByEmpNo")
    public Integer deleteByEmpNo(Integer empNo, String job){
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("empNo", empNo);
        return ehcacheService.deleteByEmpNo(paramMap);
    }

}
