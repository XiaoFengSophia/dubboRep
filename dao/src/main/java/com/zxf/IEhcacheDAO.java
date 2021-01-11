package com.zxf;

import com.zxf.entities.Emp;

import java.util.List;
import java.util.Map;

/**
 * @Author: zhaoxiaofeng
 * @Description:
 * @Date: 2020/12/19 16:10
 */
public interface IEhcacheDAO {
    List<Emp> queryAllEmp();

    Integer updateByEmpNo(Map<String, Object> paramMap);

    List<Emp> queryByEmpNo(Map<String, Object> paramMap);

    Integer deleteByEmpNo(Map<String, Object> paramMap);
}
