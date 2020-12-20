package com.zxf.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zxf.entities.Dept;
import com.zxf.entities.Emp;
import com.zxf.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @Author: zhaoxiaofeng
 * @Description:
 * @Date: 2020/7/8 14:55
 */
@RestController
public class EmpCotroller {

    @Autowired
    private IEmpService empService;

    /**
     * 查找所有員工并以入職日期降序排序
     * @return
     */
    @GetMapping(value = "/getListEmp")
    public List<Emp> getListEmp(){

        return empService.getListEmp();
    }
    /**
     * 以部门编号分组查询员工，部门编号升序
     * @return
     */
    @GetMapping(value = "/getEmpsGroupByDeptNo")
    public List<Emp> getEmpsGroupByDeptNo(){

        return empService.getEmpsGroupByDeptNo();
    }

    /**
     * 根据部门编号，查询每个部门员工信息，其中工资为与部门平均工资之差
     * @return
     */
    @GetMapping(value = "/getEmpsByDeptNo")
    public List<Emp> getEmpsByDeptNo(String deptNo){

        return empService.getEmpsByDeptNo(deptNo);
    }

}
