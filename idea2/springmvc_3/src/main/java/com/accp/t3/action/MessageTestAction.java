package com.accp.t3.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.t3.vo.UserVo;
import com.alibaba.fastjson.JSON;

/**
 * 
 * @ClassName MessageTestAction
 * @description 利用HttpMessageConvert序列化
 * @author sye
 * @date 2015年11月15日
 * @version V1.0
 */

@Controller
public class MessageTestAction {
	
	@GetMapping(value="/test1",produces= "text/html;charset=UTF-8")
	@ResponseBody
	public String transformHTML() {
		return "<h1>alert('添加成功');</h1>";
	}

	@GetMapping(value="/test2",produces= "application/xml;charset=UTF-8")
	@ResponseBody
	public String transformXML() {
		return "<students><student><id>1</id><name>亮少</name></student><student><id>2</id><name>坤少</name></student></students>";
	}

	@GetMapping(value="/test3")
	@ResponseBody
	public UserVo  transformJSONObject() {
		List<String> loves1 = new ArrayList<String>();
		loves1.add("抖音秀");
		loves1.add("独秀");
		UserVo vo1 = new UserVo(1, "陈独秀", (byte) 0, new Date(), loves1);
		return vo1;
	}

	
	
	@GetMapping(value="/test4")
	@ResponseBody
	public List<UserVo> transformJSONArray() {
		List<UserVo> data = new ArrayList<UserVo>();
		List<String> loves1 = new ArrayList<String>();
		loves1.add("抖音秀");
		loves1.add("独秀");
		UserVo vo1 = new UserVo(1, "陈独秀", (byte) 0, new Date(), loves1);
		List<String> loves2 = new ArrayList<String>();
		loves2.add("逛街");
		loves2.add("睡觉");
		UserVo vo2 = new UserVo(1, "史真美", (byte) 0, new Date(), loves2);
		data.add(vo1);
		data.add(vo2);
		return data;
	}
}
