package com.zxf.serviceImpl;

import com.zxf.IEhcacheDAO;
import com.zxf.entities.Emp;
import com.zxf.service.IEhcacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhaoxiaofeng
 * @Description:
 * @Date: 2020/12/19 16:05
 */
@Service("ehcacheService")
@CacheConfig(cacheNames = "empNo")
public class EhcacheServiceImpl implements IEhcacheService {

    @Autowired
    private IEhcacheDAO ehcacheDAO;

    @Override
    public List<Emp> queryAllEmp() {

        return ehcacheDAO.queryAllEmp();
    }

    @Override
    @CachePut(/*value = {"empNo"},*/ key = "#paramMap.get(\"empNo\")")
    public Integer updateByEmpNo(Map<String, Object> paramMap) {

        return ehcacheDAO.updateByEmpNo(paramMap);
    }

    @Override
    @Cacheable(/*value = {"empNo"},*/ keyGenerator = "myKeyGenerator")
    public List<Emp> queryByEmpNo(Map<String, Object> paramMap) {

        return ehcacheDAO.queryByEmpNo(paramMap);
    }

    @Override
    @CacheEvict(/*value = {"empNo"},*/ allEntries = true, keyGenerator = "myKeyGenerator")
    public Integer deleteByEmpNo(Map<String, Object> paramMap) {

        return ehcacheDAO.deleteByEmpNo(paramMap);
    }

}
