package com.zhi.entity;

import javax.persistence.*;

public class Dept {
    private Integer id;

    @Column(name = "dept_name")
    private String deptName;

    @Column(name = "dept_code")
    private Integer deptCode;

    @Column(name = "dept_note")
    private String deptNote;

    @Column(name = "dept_super")
    private String deptSuper;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return dept_name
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * @param deptName
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * @return dept_code
     */
    public Integer getDeptCode() {
        return deptCode;
    }

    /**
     * @param deptCode
     */
    public void setDeptCode(Integer deptCode) {
        this.deptCode = deptCode;
    }

    /**
     * @return dept_note
     */
    public String getDeptNote() {
        return deptNote;
    }

    /**
     * @param deptNote
     */
    public void setDeptNote(String deptNote) {
        this.deptNote = deptNote;
    }

    /**
     * @return dept_super
     */
    public String getDeptSuper() {
        return deptSuper;
    }

    /**
     * @param deptSuper
     */
    public void setDeptSuper(String deptSuper) {
        this.deptSuper = deptSuper;
    }
}