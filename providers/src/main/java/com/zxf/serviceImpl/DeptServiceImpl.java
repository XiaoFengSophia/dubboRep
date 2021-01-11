package com.zxf.serviceImpl;

import com.zxf.IDeptDAO;
import com.zxf.entities.Dept;
import com.zxf.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Author: zhaoxiaofeng
 * @Description:
 * @Date: 2020/7/13 10:11
 */
@Service("deptService")
public class DeptServiceImpl implements IDeptService {
    @Autowired
    private IDeptDAO deptDAO;

    @Override
    public Dept getDeptByNo(Dept dept) {
       Dept d = deptDAO.getDeptByNo(dept);
       if(d != null){
           return d;
       }
       return null;
    }

    @Override
    public List<Map<String, Object>> getResultListMap() {
        List<Map<String, Object>> listMap = deptDAO.getResultListMap();
        return listMap;
    }
}
