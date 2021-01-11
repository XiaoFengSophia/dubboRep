package com.zxf;

import com.zxf.entities.Dept;

import java.util.List;
import java.util.Map;

/**
 * @Author: zhaoxiaofeng
 * @Description:
 * @Date: 2020/7/13 10:15
 */
public interface IDeptDAO {
    public Dept getDeptByNo(Dept dept);

    List<Map<String, Object>> getResultListMap();
}
