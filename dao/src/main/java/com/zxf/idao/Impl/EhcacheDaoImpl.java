package com.zxf.idao.Impl;

import com.zxf.IEhcacheDAO;
import com.zxf.entities.Emp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhaoxiaofeng
 * @Description:
 * @Date: 2020/12/19 16:11
 */
@Transactional
@Repository("ehcacheDAO")
public class EhcacheDaoImpl implements IEhcacheDAO {

    private static Logger log = LoggerFactory.getLogger(EhcacheDaoImpl.class);

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Emp> queryAllEmp() {
        String sql = "select * from emp where 1=1";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
    }

    @Override
    public Integer updateByEmpNo(Map<String, Object> paramMap) {
        String sql = "update emp set job = :job where empNo = :empNo";
        return jdbcTemplate.update(sql, paramMap);
    }

    @Override
    public List<Emp> queryByEmpNo(Map<String, Object> paramMap) {
        String sql = "select * from emp where 1=1 and empNo = :empNo ";
        return jdbcTemplate.query(sql, paramMap, new BeanPropertyRowMapper<>(Emp.class));
    }

    @Override
    public Integer deleteByEmpNo(Map<String, Object> paramMap) {
        String sql = "delete emp where 1=1 and empNo = :empNo";
        return jdbcTemplate.update(sql, paramMap);
    }
}
