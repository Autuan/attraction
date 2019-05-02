package com.attraction.common.exception;

import com.google.gson.Gson;
import groovy.util.logging.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class ExceptionHandler implements HandlerExceptionResolver {
    private static Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse,
                                         Object o,
                                         Exception e) {
        CheckException checkException = null;
        ModelAndView modelAndView = new ModelAndView();

        //此错误是我们预期的错误
        if (e instanceof CheckException) {
            checkException = (CheckException) e;
            //错误文字信息
            String message = checkException.getMessage();
            //设置状态码和信息
            Map<String, Object> responseMap = new HashMap<String, Object>();
            responseMap.put("code", "500");
            responseMap.put("msg", message);
            String json = new Gson().toJson(responseMap);
            System.out.println(json);
            httpServletResponse.setContentType("UTF-8");
            httpServletResponse.setContentType("application/json;charset=utf-8");
            try {
                httpServletResponse.getWriter().write(json);
                httpServletResponse.getWriter().flush();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return modelAndView;
        } else {
            //非预期错误
            checkException = new CheckException(e.getMessage());
        }
        //错误文字信息
        String message = checkException.getMessage();
        logger.error("异常捕获--->异常--->{}",message);
        //判断请求的类型， 是否是json
        HandlerMethod handlerMethod = (HandlerMethod) o;
        ResponseBody responseBody = handlerMethod.getMethod().getAnnotation(ResponseBody.class);
        //是json请求， 则放回json数据
        if (responseBody != null) {
            //设置状态码和信息
            Map<String, Object> responseMap = new HashMap<String, Object>();
            responseMap.put("code", "500");
            responseMap.put("msg", message);
            String json = new Gson().toJson(responseMap);
            System.out.println(json);
            httpServletResponse.setContentType("UTF-8");
            httpServletResponse.setContentType("application/json;charset=utf-8");
            try {
                httpServletResponse.getWriter().write(json);
                httpServletResponse.getWriter().flush();
                ;
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return modelAndView;
        }

        modelAndView.addObject("message", message);

        //不是json数据， 携带message到跳转到错误页面
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
