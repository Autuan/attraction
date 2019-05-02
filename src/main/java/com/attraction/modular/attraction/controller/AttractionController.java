package com.attraction.modular.attraction.controller;

import com.attraction.modular.attraction.entity.Attraction;
import com.attraction.modular.attraction.service.IAttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/attraction")
public class AttractionController {
    @Autowired
    private IAttractionService attractionService;

    @RequestMapping("/detail")
    public ModelAndView detail(Integer id, ModelAndView mav){
        Attraction attraction = attractionService.selectById(id);
        mav.addObject("attraction", attraction);
        mav.setViewName("/attraction/detail");
        return mav;
    }
}
