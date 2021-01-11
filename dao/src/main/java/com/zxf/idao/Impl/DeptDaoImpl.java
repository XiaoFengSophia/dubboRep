package com.zxf.idao.Impl;

import com.zxf.IDeptDAO;
import com.zxf.entities.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Author: zhaoxiaofeng
 * @Description:
 * @Date: 2020/7/13 10:16
 */
@Transactional
@Repository("deptDao")
public class DeptDaoImpl implements IDeptDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Dept getDeptByNo(Dept dept) {
        String deptNo = dept.getDeptNo();
        String sql = "select * from dept d where d.deptNo = :deptNo";
        Object[] obj = new Object[]{deptNo};
        return jdbcTemplate.queryForObject(sql, obj, new BeanPropertyRowMapper<>(Dept.class));
    }

    @Override
    public List<Map<String, Object>> getResultListMap() {
        String sql = "SELECT * FROM DEPT";
        return jdbcTemplate.queryForList(sql);
    }
}
