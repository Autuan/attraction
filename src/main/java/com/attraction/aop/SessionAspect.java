package com.attraction.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *  SessionRefresh
 *      被该注解修饰的方法,执行时会刷新用户浏览器的Session过期时间
 *
 */
@Aspect
@Component
public class SessionAspect {

    @Pointcut("@annotation(com.attraction.aop.SessionRefresh)")
    public void methodAspect(){

    }

    @After("methodAspect()")
    public void doAfter(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(30*60); // 重置Session时间
    }
}
