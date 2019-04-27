package com.attraction.modular.base.controller;

import javafx.concurrent.Task;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * SSE 消息推送 -- 已废弃
 */
//@Controller
//public class SSEController {
////    @Resource(name = "commonRedisTemplate")
////    private RedisTemplate<String, String> redisTemplate;                    // redis
//
//    // ---------------------- 业务逻辑 ----------------------
//    @RequestMapping(value="/push",produces="text/event-stream;charset=utf-8")
//    @ResponseBody
//    public void  push(String msg, HttpServletResponse response) {
//        response.setContentType("text/event-stream");
//        response.setCharacterEncoding("UTF-8");
//        try {
//            String newTask = redisTemplate.opsForValue().get("newTask");
//            if (null != newTask && !newTask.equals("")) {
//                PrintWriter writer = response.getWriter();
//                writer.write("data: newTask \n\n");//这里需要\n\n，必须要，不然前台接收不到值,键必须为data
//                writer.flush();
//            }
//
//            Thread.sleep(3000);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
