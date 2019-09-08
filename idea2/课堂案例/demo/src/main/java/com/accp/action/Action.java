package com.accp.action;

import com.accp.biz.Biz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@Controller
public class Action {
    @Resource
    private Biz biz;

    @GetMapping("list")
    public String find(Model m){
        m.addAttribute("list",biz.find());
        return "index";
    }
}
