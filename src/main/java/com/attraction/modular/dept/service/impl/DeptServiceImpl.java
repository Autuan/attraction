package com.attraction.modular.dept.service.impl;

import com.attraction.modular.dept.entity.Dept;
import com.attraction.modular.dept.mapper.DeptMapper;
import com.attraction.modular.dept.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements IDeptService {
    @Autowired
    private DeptMapper deptMapper;

    // -------------------------------------------- --------------------------------------------

    /**
     * 取部门列表
     * @return
     */
    @Override
    public List<Dept> getDeptList() {
        return deptMapper.getDeptList();
    }

    /**
     * 新增部门
     * @param dept
     */
    @Override
    public void insertDept(Dept dept) {
        deptMapper.insertSelective(dept);
    }

    /**
     * 更新部门
     * @param dept
     */
    @Override
    public void updateDept(Dept dept) {
        deptMapper.updateByPrimaryKeySelective(dept);
    }

    /**
     * 删除部门
     * @param deptId
     */
    @Override
    public void deleteDept(Integer deptId) {
        deptMapper.deleteByPrimaryKey(deptId);
    }
}
