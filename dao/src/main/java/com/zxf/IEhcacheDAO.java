package com.zxf;

import com.zxf.entities.Emp;

import java.util.List;

/**
 * @Author: zhaoxiaofeng
 * @Description:
 * @Date: 2020/12/19 16:10
 */
public interface IEhcacheDAO {
    List<Emp> queryAllEmp();
}
