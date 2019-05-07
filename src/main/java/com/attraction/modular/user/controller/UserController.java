package com.attraction.modular.user.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.attraction.aop.SessionRefresh;
import com.attraction.common.entity.PageResult;
import com.attraction.common.entity.ReturnResult;
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
    @RequestMapping("/updateUser")
    @ResponseBody
    public ReturnResult updateUser(User user){
        try {
            if (user.getUserPassword().length() > 30) {
                user.setUserPassword(null);
            }
            userService.updateUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnResult.error("失败");
        }
        return ReturnResult.ok();
    }

     /**
     * 删除用户
     * @return
     */
    @RequestMapping("/deleteUser")
    @ResponseBody
    public ReturnResult deleteUser(Integer userId,HttpServletRequest request){
        try {
            // 验证用户id
            Integer name = (Integer) request.getSession().getAttribute("userId");
            if ( userId.equals(1)) {
                // id 为 1  是默认管理员,不可以删除
                return ReturnResult.error("管理员账户不能删除");
            }
            if ( userId.equals(name)) {
                // 登陆用户不可以删除自己
                return ReturnResult.error("不能删除自己");
            }
            userService.deleteUser(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnResult.error("操作失败");
        }
        return ReturnResult.ok();
    }

    /**
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

    @RequestMapping("/userList")
    public String userPage(){
        return "/user/userList";
    }
}
