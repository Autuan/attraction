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

    /**
     * 部门信息Excel表格下载
     * @param response null
     * @return
     * @throws IOException
     */
    @RequestMapping("generatorExcel")
    @SessionRefresh
    public String generatorExcel(HttpServletResponse response)throws IOException{
        String title = "部门列表--互联网产业集群反馈系统";
        // 生成Excel文档
        List<Dept> list = deptService.getDeptList();
        Workbook workbook =  ExcelExportUtil.exportExcel(new ExportParams(title,"部门列表"),
                Dept .class, list);


        //同理可以设置数据行
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            workbook.write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] content = os.toByteArray();
        InputStream is = new ByteArrayInputStream(content);
        // 设置response参数，可以打开下载页面
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename="+ new String(( title + WebUtil.getCurrentTimeNoMark() + ".xls").getBytes(), "ISO8859-1"));
        ServletOutputStream out = response.getOutputStream();
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(is);
            bos = new BufferedOutputStream(out);
            byte[] buff = new byte[2048];
            int bytesRead;
            // Simple read/write loop.
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
                bos.write(buff, 0, bytesRead);
            }
        } catch (final IOException e) {
            throw e;
        } finally {
            if (bis != null)
                bis.close();
            if (bos != null)
                bos.close();
        }
        return null;
    }

}
