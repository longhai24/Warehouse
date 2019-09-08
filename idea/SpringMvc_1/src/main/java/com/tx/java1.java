package com.tx;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @description:
 * @author: apple
 * @date: 2019-06-04 9:04
 */
@Controller
public class java1{
    @RequestMapping(value="/loginIn",method= {RequestMethod.POST,RequestMethod.GET})
    public String login(){
        return "WEB-INF/jsp/jsa.jsp";
    }
    @RequestMapping(value="tomenu",method= {RequestMethod.POST,RequestMethod.GET})
        public String menu(Model model,String name){
            model.addAttribute("user",name);
            return "WEB-INF/jsp/jsp2.jsp";
        }
}
