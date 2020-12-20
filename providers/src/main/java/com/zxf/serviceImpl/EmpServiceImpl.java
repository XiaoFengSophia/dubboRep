package com.zxf.serviceImpl;

import com.zxf.IEmpDAO;
import com.zxf.entities.Dept;
import com.zxf.entities.Emp;
import com.zxf.service.IEmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zhaoxiaofeng
 * @Description:
 * @Date: 2020/7/8 14:52
 */
@Service("empService")
public class EmpServiceImpl implements IEmpService {
    @Autowired
    private IEmpDAO empDao;

    @Override
    public List<Emp> getListEmp() {
        List<Emp> list = empDao.getListEmp();
        System.out.println("list:" + list);
        return list;
    }

    @Override
    public List<Emp> getEmpsGroupByDeptNo() {
        List<Emp> list = empDao.getEmpsGroupByDeptNo();
        return list;
    }

    @Override
    public List<Emp> getEmpsByDeptNo(String deptNo) {
        List<Emp> list = empDao.getEmpsByDeptNo(deptNo);
        return list;
    }

}
