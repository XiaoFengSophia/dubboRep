package com.zxf.idao.Impl;

import com.zxf.IEhcacheDAO;
import com.zxf.entities.Emp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Emp> queryAllEmp() {
        String sql = "select * from emp where 1=1";
        log.info(sql);
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
    }
}
