package com.attraction.common.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @ClassName:  WebUtil   
 * @Description: 工具类 取当前时间 取ip地址
 * @author: 于先知(AutuanYu) 
 * @date:   2017年12月1日 下午9:39:13   
 *     
 * @Copyright: 2017 github.com/Autuan Inc. All rights reserved. 
 * 注意：本内容仅限于学习使用
 */
public class WebUtil {
	/**
	 * 
	 * @Title: getCurrentTime   
	 * @Description:  时间戳
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String getCurrentTime() {
		 Date date = new Date();
		 String str = null;
		 SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 str = df.format(date);
		 return str;
	}


	/**
	 *
	 * @Title: getCurrentDay
	 * @Description: TODO 年月日
	 * @param: @return
	 * @return: String
	 * @throws
	 */
	public static String getCurrentDay() {
		Date date = new Date();
		String str = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		str = df.format(date);
		return str;
	}

	/**
	 * 获取明天的日期
	 * @return
	 */
	public static String getTomorrow() {
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DATE,+1);
		Date d=cal.getTime();
		SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
		String theDay=sp.format(d);//获取日期
		return theDay;
	}

	/**
	 * 
	 * @Title: getCurrentTime   
	 * @Description: TODO 时间戳    
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String getCurrentTimeNoMark() {
		Date date = new Date();
		String str = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
		str = df.format(date);
		return str;
	}
	
	/**
	 * 
	 * @Title: getCurrentIp   
	 * @Description: TODO  ip 地址  
	 * @param: @param request
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	public static String getCurrentIp(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
	}
}
