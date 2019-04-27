package com.attraction.modular.base.controller;

import com.attraction.common.entity.EchartBarResult;
import com.attraction.common.entity.EchartPieResult;
import com.attraction.common.util.WebUtil;
import com.attraction.modular.feedback.service.IFeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 管理员登陆图表加载 控制器
 */
@Controller
public class EChartController {
    // ---------------------- 自动注入 ----------------------
    @Autowired
    private IFeedBackService feedBackService;           // 反馈服务

    // ---------------------- 业务逻辑 ----------------------

    /**
     * 统计最近一周反馈
     * @return
     */
    @RequestMapping("/countFeedbackLastWeek")
    @ResponseBody
    public EchartBarResult countFeedbackLastWeek(){
        EchartBarResult result = new EchartBarResult();
        String[] categories = new String[7];
        Object[] data = new Object[7];
        // 填充7天的数据
        String theEndDay = WebUtil.getTomorrow();
        for ( int i=0;i<7;i++ ) {
            Calendar cal=Calendar.getInstance();
            cal.add(Calendar.DATE,-i);
            Date d=cal.getTime();
            SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
            String theDay=sp.format(d);//获取日期
            Integer nums = feedBackService.getCountFeedbackByDay(theDay,theEndDay);
            categories[Math.abs(i-6)]=theDay;
            data[Math.abs(i-6)] = nums;
            theEndDay = theDay;
        }

        result.setCategories(categories);
        result.setData(data);
        return result;
    }


    /**
     * 统计最近一周统计完成情况
     * @return
     */
    @RequestMapping("/countFeedbackGroupByStatusLastWeek")
    @ResponseBody
    public List<EchartPieResult> countFeedbackGroupByStatusLastWeek(){
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DATE,-6);
        Date d=cal.getTime();
        SimpleDateFormat sp=new SimpleDateFormat("yyyy-MM-dd");
        String endDay=sp.format(d);//获取日期
        return feedBackService.countFeedbackGroupByStatusLastWeek(endDay,WebUtil.getCurrentDay()+ " 23:59:59");
    }


    /**
     * 统计今天的反馈信息
     * @return
     */
    @ResponseBody
    @RequestMapping("/getStatistics")
    public List<Map<String,Object>> getStatistics(){
        List<Map<String, Object>> list = new ArrayList<>();
        String today = WebUtil.getCurrentDay();
        Map<String,Object> map = feedBackService.countAllFeedback(); // 反馈问题总数
        list.add(map);

        map = feedBackService.countNotDoneFeedback(); // 未完成问题总数
        list.add(map);

        map = feedBackService.countFeedbackOnlyToday(today); // 今日问题总数
        list.add(map);

        map = feedBackService.countNotDoneFeedbackOnlyToday(today); // 今日未完成问题总数
        list.add(map);

        return list;
    }
}
