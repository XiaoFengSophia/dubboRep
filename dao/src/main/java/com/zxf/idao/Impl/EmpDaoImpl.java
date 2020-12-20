package com.zxf.idao.Impl;

import com.zxf.IEmpDAO;
import com.zxf.entities.Dept;
import com.zxf.entities.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: zhaoxiaofeng
 * @Description:
 * @Date: 2020/7/8 14:40
 */
@Transactional
@Repository("empIdao")
public class EmpDaoImpl implements IEmpDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Emp> getListEmp() {
        String sql = "select * from emp order by hiredate desc";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
    }

    @Override
    public List<Emp> getEmpsGroupByDeptNo() {
        String sql = "select e.EMPNO, e.ENAME, e.JOB, e.MGR, e.HIREDATE, e.SAL, e.COMM, e.DEPTNO from emp e, dept d where e.deptNo = d.deptNo group by d.DEPTNO,e.EMPNO, e.ENAME, e.JOB, e.MGR, e.HIREDATE, e.SAL, e.COMM order by e.DEPTNO";

        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Emp.class));
    }

    @Override
    public List<Emp> getEmpsByDeptNo(String deptNo) {
        Object[] obj = new Object[]{deptNo};
        String sql = "select e.EMPNO, e.ENAME, e.JOB, e.MGR, e.HIREDATE, e.SAL-t.avg_sal as sal, e.COMM, e.DEPTNO  from emp e inner join (select round(avg(sal), 2) avg_sal, e.DEPTNO from emp e group by e.DEPTNO) t on e.DEPTNO = t.DEPTNO and e.DEPTNO = :deptNo";
        return jdbcTemplate.query(sql, obj, new BeanPropertyRowMapper<>(Emp.class));
    }

}
