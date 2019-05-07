package com.attraction.modular.attraction.controller;

import com.attraction.aop.SessionRefresh;
import com.attraction.common.entity.PageResult;
import com.attraction.common.entity.ReturnResult;
import com.attraction.modular.attraction.entity.Attraction;
import com.attraction.modular.attraction.service.IAttractionService;
import com.attraction.modular.attraction.entity.Attraction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin/attraction")
public class AdminAttractionController {
    @Autowired
    private IAttractionService attractionService;


    @RequestMapping("/listPage")
    public String listPage(){
        return "/attraction/admin_list";
    }

    @RequestMapping("/addPage")
    public String addPage(){
        return "/attraction/admin_detail";
    }

    @RequestMapping("/editPage")
    public ModelAndView editPage(Integer id, ModelAndView mav) {
        Attraction attraction = attractionService.selectById(id);
        mav.setViewName("/attraction/admin_detail");
        mav.addObject("attraction", attraction);
        return mav;
    }

    @RequestMapping("/list")
    @ResponseBody
    public PageResult list(@RequestParam(defaultValue = "1",value = "pageNumber") Integer page,
                           @RequestParam(value = "pageSize") Integer rows){
        PageResult pageResult = new PageResult();
        List<Attraction> list = attractionService.list();
        pageResult.setRows(list);
        pageResult.setTotal(list.size());
        return pageResult;
    }

    /**
     * 增加
     * @param attraction
     * @return
     */
    @RequestMapping("/insertAttraction")
    @ResponseBody
    public ReturnResult insertAttraction(Attraction attraction) {
        try {
            attractionService.insert(attraction);
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnResult.error();
        }
        return ReturnResult.ok();
    }

    /**
     * 修改
     * @param attraction
     * @return
     */
    @RequestMapping("/updateAttraction")
    @ResponseBody
    public ReturnResult updateAttraction(Attraction attraction){
        try {
            attractionService.update(attraction);
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnResult.error();
        }
        return ReturnResult.ok();
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/deleteAttraction")
    @ResponseBody
    public ReturnResult deleteAttraction(Integer id){
        try {
            attractionService.delete(id);
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnResult.error();
        }
        return ReturnResult.ok();
    }
}
