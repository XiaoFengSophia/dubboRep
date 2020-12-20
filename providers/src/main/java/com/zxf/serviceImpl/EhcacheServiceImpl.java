package com.zxf.serviceImpl;

import com.zxf.IEhcacheDAO;
import com.zxf.entities.Emp;
import com.zxf.service.IEhcacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: zhaoxiaofeng
 * @Description:
 * @Date: 2020/12/19 16:05
 */
@Service("ehcacheService")
public class EhcacheServiceImpl implements IEhcacheService {

    @Autowired
    private IEhcacheDAO ehcacheDAO;

    @Override
    public List<Emp> queryAllEmp() {

        return ehcacheDAO.queryAllEmp();
    }
}
