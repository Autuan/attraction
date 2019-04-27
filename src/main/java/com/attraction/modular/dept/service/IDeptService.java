package com.attraction.modular.dept.service;

import com.attraction.modular.dept.entity.Dept;

import java.util.List;

public interface IDeptService {
    /**
     * 取列表
     * @return
     */
    List<Dept> getDeptList();

    /**
     * 新增
     * @param dept
     */
    void insertDept(Dept dept);

    /**
     * 修改
     * @param dept
     */
    void updateDept(Dept dept);

    /**
     * 删除
     * @param deptId
     */
    void deleteDept(Integer deptId);
}
