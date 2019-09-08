package com.tx.action;

import com.tx.biz.FlightinfoBiz;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @description:
 * @author: apple
 * @date: 2019-06-05 8:50
 */
@Controller
@RequestMapping("/fly")
public class FlightAction {
    @Resource
    private FlightinfoBiz flyBiz;

    @GetMapping("toindex")
    public String tojsp2(){
        return "index";
    }
    @PostMapping ("tosel")
    public String tosel(Model model,String sid){
        model.addAttribute("list",  flyBiz.selSome(sid));
        return "sel";
    }
}
