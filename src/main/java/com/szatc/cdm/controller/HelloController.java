package com.szatc.cdm.controller;

import com.szatc.cdm.common.constant.Global;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/monitor")
public class HelloController {

    @RequestMapping(value = "/index")
    public ModelAndView monitor(ModelAndView modelAndView) {
        modelAndView.setViewName("monitor");
        String receiveTime= Global.receiveTime;
        String sendTime= Global.sendTime;
        String sendAtrs=Global.sendAtrs;
        modelAndView.addObject("receiveTime", receiveTime);
        modelAndView.addObject("sendTime", sendTime);
        modelAndView.addObject("sendAtrs", sendAtrs);
        return modelAndView;
    }
    @ResponseBody
    @RequestMapping("/receiveTime")
    public String receiveTime(){
        return Global.receiveTime;
    }

    @ResponseBody
    @RequestMapping("/sendTime")
    public String sendTime(){
        return Global.sendTime;
    }

    @ResponseBody
    @RequestMapping("/sendAtrs")
    public String sendAtrs(){
        return Global.sendAtrs;
    }

}
