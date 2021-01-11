package com.zxf;

import com.zxf.entities.Dept;
import com.zxf.entities.Emp;

import java.util.List;

/**
 * @Author: zhaoxiaofeng
 * @Description:
 * @Date: 2020/7/8 14:39
 */
public interface IEmpDAO {
    public List<Emp> getListEmp();

    List<Emp> getEmpsGroupByDeptNo();

    List<Emp> getEmpsByDeptNo(String deptNo);

}
