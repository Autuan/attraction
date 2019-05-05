package com.attraction.modular.user.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.attraction.aop.SessionRefresh;
import com.attraction.common.entity.PageResult;
import com.attraction.common.util.JsonUtils;
import com.attraction.common.util.LoginUtil;
import com.attraction.common.util.WebUtil;
import com.attraction.modular.user.entity.LoginTable;
import com.attraction.modular.user.entity.User;
import com.attraction.modular.user.service.IUserService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/user")
public class UserController {
    @Autowired
    private IUserService userService;

    /**
     * 获取用户列表
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/getUserList")
    @ResponseBody
    public PageResult getPageUser(@RequestParam(defaultValue = "1",value = "pageNumber") Integer page,
                                      @RequestParam(value = "pageSize") Integer rows){
        PageResult pageResult = new PageResult();
        List<User> feedbackList = userService.getUserList(page, rows);
        int total = userService.countAll();
        pageResult.setTotal(total);
        pageResult.setRows(feedbackList);
        return pageResult;
    }

    /**
     * 创建用户
     * @param user
     * @return
     */
    @SessionRefresh
    @RequestMapping("/insertUser")
    @ResponseBody
    public String insertUser(User user) {
        // 重复查询

        try {
            User tempUser = userService.getUserByName(user.getUserUsername());
            if ( null != tempUser ) {
                return "repeatUsername";
            }
            Integer num = userService.haveThisUser(user.getUserLogname());
            if ( num == 1) {
                return "repeatLogName";
            }

            userService.insertUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    /**
     * 登陆方法
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public Map<String,String> login(String logname, String password, HttpServletRequest request){
        Map<String,String> map = new HashMap<String,String>(16);

        // 用户名核对
        Integer num = userService.haveThisUser(logname);
        if ( num <= 0 ) {
            map.put("describe","用户名错误");
            return map;
        }
        // 密码核对
        // 丨→字符加密
        password = LoginUtil.getSHA256Str(password);
        // 丨→验证
        LoginTable loginTable = userService.tryLog(logname,password);
        if ( null == loginTable ) {
            map.put("describe","密码错误");
        } else {
            // 执行登陆成功指令
            // 丨→保存 session 在服务器
            HttpSession session = request.getSession();
            session.setAttribute("userId", loginTable.getLoginId());
            session.setAttribute("userInfo", loginTable.getLoginRoleId());
            // 时间设置(session默认过期时间单位为秒)
            session.setMaxInactiveInterval(30*60);
            map.put("result","success");
            map.put("describe", WebUtil.getCurrentTimeNoMark());
        }
        return map;
    }

    /**
     * 获取执行人员列表
     * @return
     */
    @GetMapping("/getActiveList")
    @ResponseBody
    public List<User> getActiveList(){
        return userService.getActiveList();
    }

    /**
     * 根据id取名字
     * @param userId
     * @return
     */
    @GetMapping("/getNameById")
    @ResponseBody
    public String getNameById(Integer userId) throws Exception{
        String str = userService.getNameById(userId);
        str = new String(str.getBytes("ISO-8859-1"), "utf-8");
        return JsonUtils.objectToJson(str);
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @SessionRefresh
    @RequestMapping("/updateUser")
    @ResponseBody
    public String updateUser(User user){
        try {
            if (user.getUserPassword().length() > 30) {
                user.setUserPassword(null);
            }
            userService.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

     /**
     * 删除用户
     * @return
     */
    @RequestMapping("/deleteUser")
    @ResponseBody
    @SessionRefresh
    public String deleteUser(Integer userId,HttpServletRequest request){
        try {
            // 验证用户id
            Integer name = (Integer) request.getSession().getAttribute("userId");
            if ( userId.equals(1)) {
                return "cannotDeleteAdmin"; // id 为 1  是默认管理员,不可以删除
            }
            if ( userId.equals(name)) {
                return "cannotDeleteYourself"; // 登陆用户不可以删除自己
            }
            userService.deleteUser(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    /**
     * 取提交人
     * @return
     */
    @RequestMapping("/getPushMan")
    @ResponseBody
    public List<User> getPushMan(){
        return userService.getPushMan();
    }

    /**
     * 根据部门id取用户列表
     * @param deptId
     * @return
     */
    @RequestMapping("/getUserByDeptId")
    @ResponseBody
    public List<User> getUserByDeptId(Integer deptId){
        return userService.getUserByDeptId(deptId);
    }

    /**
     * 获取主管及技术人员列表
     * @return
     */
    @RequestMapping("/getAdminAndTechnology")
    @ResponseBody
    public List<User> getAdminAndTechnology(){
        return userService.getAdminAndTechnology();
    }

    /**
     * 根据用户id查找用户
     * @param userId 用户id
     * @return
     */
    @ResponseBody
    @GetMapping("/getUser")
    public User getUserById(Integer userId) {
        return userService.getUserById(userId);
    }

    @RequestMapping("generatorExcel")
    @SessionRefresh
    public String generatorExcel(HttpServletResponse response)throws IOException {
        String title = "用户列表--畅游管理系统";
        // 生成Excel文档
        List<User> list = userService.getUserList(0, 999);
        Workbook workbook =  ExcelExportUtil.exportExcel(new ExportParams(title,"用户列表"),
                User .class, list);


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
