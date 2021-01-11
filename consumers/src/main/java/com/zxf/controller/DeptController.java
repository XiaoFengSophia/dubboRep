package com.zxf.controller;

import com.zxf.entities.Dept;
import com.zxf.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author: zhaoxiaofeng
 * @Description:
 * @Date: 2020/7/13 10:03
 */
@RestController
public class DeptController {
    @Autowired
    private IDeptService deptService;
    /**
     * 参数为实体对象
     * @return
     */
    @PostMapping(value = "/getDeptByNo")
    public Dept getDeptByNo(@RequestBody Dept dept){

        return deptService.getDeptByNo(dept);
    }

    /**
     *返回结果集是List<Map<String, Object>
     * @return
     */
    @GetMapping(value = "/getResultListMap")
    public List<Map<String, Object>> getResultListMap(){

        return deptService.getResultListMap();
    }

}
