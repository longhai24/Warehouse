package com.accp.t3.action;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;
import javax.swing.text.html.ImageView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.t3.biz.PersonBiz;
import com.accp.t3.pojo.Person;
import com.accp.t3.util.Base64ConvertImageUtil;
import com.accp.t3.vo.Base64ImageVo;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/person") // 命名空间
public class PersonAction {

	@Autowired
	private PersonBiz personBiz;

	@GetMapping(value = "list")
	@ResponseBody
	public PageInfo<Person> getPersonListByPage(Integer num, Integer size) {
		return personBiz.findPersonListByPage(num, size);
	}

	@GetMapping(value = "del")
	@ResponseBody
	public Map<String, String> delPersonInfo(Integer pid) {
		personBiz.removePersonById(pid);
		Map<String, String> message = new HashMap<String, String>();
		message.put("code", "200");
		message.put("msg", "ok");
		return message;
	}
	
	@PostMapping(value = "add1")
	@ResponseBody
	public Map<String, String> addPersonInfo1(@RequestBody Person person) {
		personBiz.addPerson(person);
		Map<String, String> message = new HashMap<String, String>();
		message.put("code", "200");
		message.put("msg", "ok");
		return message;
	}
	
	@PostMapping(value = "add2")
	@ResponseBody
	public Map<String, String> addPersonInfo2(@RequestBody Person[] persons) {
		for (Person person : persons) {
			personBiz.addPerson(person);
		}
		Map<String, String> message = new HashMap<String, String>();
		message.put("code", "200");
		message.put("msg", "ok");
		return message;
	}

//	@RequestMapping(value = "add", method = RequestMethod.POST)
//	public Map<String, String> addPersonInfo(HttpSession session,@RequestBody Base64ImageVo imgVo) {
//		// 获得指定文件的绝对路径
//		String realPath = session.getServletContext().getRealPath("/images");
//
//		// 利用uuid产生唯一文件名
//		String fileName = UUID.randomUUID().toString().replace("-", "")
//				+ imgVo.getName().substring(imgVo.getName().lastIndexOf("."));
//		String path = realPath + File.separator + fileName;
//		Person person = imgVo.getPerson();
//		person.setPimg(fileName);
//		personBiz.addPerson(person);
//		Base64ConvertImageUtil.generateImageFromBase64(imgVo.getData(), path);//非常重要
//		Map<String, String> message = new HashMap<String, String>();
//		message.put("code", "200");
//		message.put("msg", "ok");
//		return message;
//	}

}
