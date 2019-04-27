package com.attraction.modular.feedback.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.attraction.aop.SessionRefresh;
import com.attraction.common.util.WebUtil;
import com.attraction.modular.feedback.entity.Feedback;
import com.attraction.common.entity.PageResult;
import com.attraction.modular.feedback.service.IFeedBackService;
import com.attraction.modular.user.service.IUserService;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;

@Controller
@RequestMapping("/admin/feedback")
public class FeedbackController {
    // -------------------------------------------- 常量 --------------------------------------------
    private String FTP_ADDRESS = "ftp://www.daobc.cn";

    private String FTP_PORT = "21";

    private String FTP_USERNAME = "root";

    private String FTP_PASSWORD = "root";

    private String FTP_BASE_PATH = "";

    private String IMAGE_BASE_URL = "http://192.168.1.12:5550/";

    // -------------------------------------------- 自动注入 --------------------------------------------
    @Autowired
    private IFeedBackService feedBackService;

    @Autowired
    private IUserService userService;

//        @Resource(name = "commonRedisTemplate")
//    private RedisTemplate<String, String> redisTemplate;                    // redis

    // -------------------------------------------- 业务逻辑 --------------------------------------------

    @RequestMapping(value = {"/getPageFeedback", "/getPageFeedbackByUserId",
            "/getPageFeedbackByStatus", "/getPageFeedbackByUserIdAndStatus"})
    @ResponseBody
    public PageResult getFeedbackList(@RequestParam(defaultValue = "1", value = "pageNumber") Integer page,
                                      @RequestParam(value = "pageSize") Integer rows,
                                      Integer userId, Integer statusId, HttpServletRequest request) {
        if (null == userId) {
            Integer userInfo = (Integer) request.getSession().getAttribute("userInfo");
            if (userInfo.equals(0)) {
                userId = (Integer) request.getSession().getAttribute("userId");
            }
        }
        PageResult pageResult = new PageResult();
        List<Feedback> feedbackList = feedBackService.getFeedbackList(page, rows, userId, statusId);
        int total = feedBackService.getCountFeedbackByDay("2001-01-01", WebUtil.getTomorrow());
        pageResult.setTotal(total);
        pageResult.setRows(feedbackList);
        return pageResult;
    }

    @RequestMapping("/distributionTask")
    @ResponseBody
    @SessionRefresh
    public String distributionTask(Integer feedbackId, Integer userId, Integer actionId) {
        // 检查权限

        // 任务分配
        try {
            feedBackService.updateFeedback(feedbackId, actionId, 1);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    /**
     * 完成 任务
     *
     * @param feedbackId
     * @param userId
     * @param request
     * @return
     */
    @RequestMapping("/doneTask")
    @ResponseBody
    @SessionRefresh
    public String doneTask(Integer feedbackId, Integer userId, HttpServletRequest request) {
        try {
            Integer power = (Integer) request.getSession().getAttribute("userInfo");
            if (power == 0) {
                return "noPower";
            }
            Integer userIds = (Integer) request.getSession().getAttribute("userId");
            feedBackService.updateFeedback(feedbackId, userIds, 2);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    /**
     * 开始任务
     *
     * @param feedbackId
     * @param userId
     * @param request
     * @return
     */
    @RequestMapping("/beginTask")
    @ResponseBody
    @SessionRefresh
    public String beginTask(Integer feedbackId, Integer userId, HttpServletRequest request) {
        try {
            Integer power = (Integer) request.getSession().getAttribute("userInfo");
            if (power == 0) {
                return "noPower";
            }
            Integer userIds = (Integer) request.getSession().getAttribute("userId");
            feedBackService.updateFeedback(feedbackId, userIds, 1);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    /**
     * 新反馈
     *
     * @param feedback
     * @param userId
     * @param request
     * @return
     */
    @RequestMapping("/insertFeedback")
    @SessionRefresh
    @ResponseBody
    public String insertFeedback(Feedback feedback, Integer userId, HttpServletRequest request) {
        try {
            Integer userIds = (Integer) request.getSession().getAttribute("userId");
            Integer userInfo = (Integer) request.getSession().getAttribute("userInfo");
            feedback.setFeedbackPushMan(userIds);
            feedBackService.insertFeedback(feedback);
            // 将信息存到Redis 中 用于服务通知
//            redisTemplate.opsForValue().set("newTask", userInfo.toString(), 6000, TimeUnit.SECONDS);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }


    /**
     * 回复反馈
     *
     * @param feedbackId
     * @param content
     * @param request
     * @return
     */
    @PostMapping("/reply")
    @ResponseBody
    @SessionRefresh
    public String reply(Integer feedbackId, String content, HttpServletRequest request) {
        try {
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            Integer userInfo = (Integer) request.getSession().getAttribute("userInfo");
            if (userInfo.equals(0)) {
                userInfo = 4;
            } else {
                userInfo = 3;
            }
            feedBackService.updateFeedback(feedbackId, userId, content, userInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    /**
     * 删除反馈
     *
     * @param feedbackId
     * @return
     */
    @RequestMapping("/deleteFeedback")
    @ResponseBody
    @SessionRefresh
    public String deleteFeedback(Integer feedbackId) {
        try {
            feedBackService.deleteFeedback(feedbackId);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    /**
     * 取反馈的状态
     *
     * @return
     */
    @RequestMapping("/getFeedbackStatus")
    @ResponseBody
    public List<Feedback> getFeedbackStatus() {
        return feedBackService.getFeedbackStatus();
    }

    /**
     * 修改反馈--主管权限
     *
     * @param feedback
     * @param request
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    @SessionRefresh
    public String updateFeedback(Feedback feedback, HttpServletRequest request) {
        // 权限验证
        Integer userInfo = (Integer) request.getSession().getAttribute("userInfo");
        if (userInfo != 1) {
            return "noPower";
        }
        // 修改
        try {
            int i = feedBackService.updateFeedback(feedback);
            if (i == 1) {
                return "success";
            } else {
                return "fail";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
    }


    /**
     * 反馈 生成excel
     *
     * @param response
     * @return
     * @throws IOException
     */
    @RequestMapping("/generatorExcel")
    @SessionRefresh
    public String generatorExcel(HttpServletResponse response) throws IOException {
        String title = "反馈列表--互联网产业集群反馈系统";
        // 生成Excel文档
        List<Feedback> list = feedBackService.getFeedbackList(null, null, null, null);
        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(title, "反馈列表"),
                Feedback.class, list);


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
        response.setHeader("Content-Disposition", "attachment;filename=" + new String((title + WebUtil.getCurrentTimeNoMark() + ".xls").getBytes(), "ISO8859-1"));
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
