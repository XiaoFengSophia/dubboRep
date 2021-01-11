package com.zxf.entities;

import java.io.Serializable;

/**
 * @Author: zhaoxiaofeng
 * @Description:
 * @Date: 2020/7/13 9:45
 */
public class Dept implements Serializable {
    private String deptNo;
    private String dName;
    private String loc;

    public Dept() {
    }

    public Dept(String deptNo, String dName, String loc) {
        this.deptNo = deptNo;
        this.dName = dName;
        this.loc = loc;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptNo='" + deptNo + '\'' +
                ", dName='" + dName + '\'' +
                ", loc='" + loc + '\'' +
                '}';
    }
}
