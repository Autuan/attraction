package com.attraction.modular.dept.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.attraction.aop.SessionRefresh;
import com.attraction.common.entity.PageResult;
import com.attraction.common.util.WebUtil;
import com.attraction.modular.dept.entity.Dept;
import com.attraction.modular.dept.service.IDeptService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@Controller
@RequestMapping("/admin/dept")
public class DeptController {
    //---------------------- 自动注入 ----------------------
    @Autowired
    private IDeptService deptService;

    // ---------------------- 逻辑处理 ----------------------

    /**
     * 取部门列表(用于填充下拉列表)
     * @return
     */
    @RequestMapping("/getDeptList")
    @ResponseBody
    public List<Dept> getDeptList(){
        List<Dept> depts =  deptService.getDeptList();
        return depts;
    }

    /**
     * 取部门列表(用于列表展示)
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/getDeptListPage")
    @ResponseBody
    public PageResult getPageFeedback(@RequestParam(defaultValue = "1",value = "pageNumber") Integer page,
                                      @RequestParam(value = "pageSize") Integer rows){
        PageResult pageResult = new PageResult();
        List<Dept> deptList = deptService.getDeptList();
        pageResult.setRows(deptList);
        pageResult.setTotal(deptList.size());
        return pageResult;
    }

    /**
     * 增加新部门
     * @param dept
     * @return
     */
    @SessionRefresh
    @RequestMapping("/insertDept")
    @ResponseBody
    public String insertDept(Dept dept) {
        try {
            deptService.insertDept(dept);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    /**
     * 修改部门
     * @param dept
     * @return
     */
    @SessionRefresh
    @RequestMapping("/updateDept")
    @ResponseBody
    public String updateDept(Dept dept){
        try {
            deptService.updateDept(dept);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    /**
     * 删除部门
     * @param deptId
     * @return
     */
    @SessionRefresh
    @RequestMapping("/deleteDept")
    @ResponseBody
    public String deleteDept(Integer deptId){
        try {
            deptService.deleteDept(deptId);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping("/deptList")
    public String deptList(){
        return "/dept/deptList";
    }
}
