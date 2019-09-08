package com.accp.t2.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accp.t2.exception.BizException;

@Controller
@RequestMapping("/demo")
public class DemoAction {
	
	
	//1.局部处理异常
	/*@ExceptionHandler(value= {BizException.class,Exception.class})
	public String handlerMyException(Exception ex) {
		System.out.println("异常信息:"+ex.getMessage());
		return "syserror";
	}*/
	
	
	@RequestMapping("show")
	public String showData(Model model, Integer num) throws Exception {
		String[] strs= {"史真香","陈独秀","刘光蓝"};
		String str=strs[3];
		model.addAttribute("DATA", strs);
		return "demo";
	}
}
