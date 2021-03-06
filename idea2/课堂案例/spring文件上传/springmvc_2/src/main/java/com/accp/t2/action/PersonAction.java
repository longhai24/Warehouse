package com.accp.t2.action;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.accp.t2.biz.PersonBiz;
import com.accp.t2.pojo.Person;
import com.github.pagehelper.PageInfo;


@Controller
@RequestMapping("/person")  //命名空间
public class PersonAction {
	
	@Resource
	private PersonBiz personBiz;
	
	
	@GetMapping("list")
	public String queryPage(Integer p,Integer s,Model model) {
		model.addAttribute("PAGE_INFO", personBiz.findPersonListByPage(p, s));
		return "index";//文件名
	}
	
	
	@GetMapping("delete")
	public String deletePerson(Integer pid) {
		personBiz.removePersonById(pid);
		return "redirect:/person/list?p=1&s=3";//文件名
	}
	
	@PostMapping("add")
	public String addPerson(Person pojo,MultipartFile imgFile,HttpSession session) {
//		System.out.println(imgFile.getName());//字段名称
//		System.out.println(imgFile.getOriginalFilename());//文件名
		try {
			String exFileName=imgFile.getOriginalFilename().substring(imgFile.getOriginalFilename().lastIndexOf("."));
			String fileName=UUID.randomUUID().toString().replace("-", "")+exFileName;
			//获得真实路径
			imgFile.transferTo(new File(session.getServletContext().getRealPath("/images")+"/"+fileName));
			pojo.setPimg(fileName);
			personBiz.addPerson(pojo);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return "redirect:/person/list?p=1&s=3";//文件名
	}

	
}
