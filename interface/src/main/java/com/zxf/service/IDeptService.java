package com.zxf.service;

import com.zxf.entities.Dept;

import java.util.List;
import java.util.Map;

/**
 * @Author: zhaoxiaofeng
 * @Description:
 * @Date: 2020/7/13 9:58
 */
public interface IDeptService {
    Dept getDeptByNo(Dept dept);

    List<Map<String, Object>> getResultListMap();
}
