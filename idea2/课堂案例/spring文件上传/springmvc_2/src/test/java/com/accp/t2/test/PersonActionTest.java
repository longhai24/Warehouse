package com.accp.t2.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.accp.t2.pojo.Person;
import com.github.pagehelper.PageInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/spring-web.xml" })
@WebAppConfiguration // 非常重要
public class PersonActionTest {

	@Autowired
	private WebApplicationContext wac;// 非常重要

	private MockMvc mockMvc;// mvc_handler测试对象

	@Before
	public void initMockMvc() {
		// 构建者模式
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	/**
	 * 关键方法 perform：执行一个RequestBuilder请求，会自动执行SpringMVC的流程并映射到相应的控制器执行处理；
	 * andExpect：添加ResultMatcher验证规则，验证控制器执行完成后结果是否正确；
	 * andDo：添加ResultHandler结果处理器，比如调试时打印结果到控制台；
	 * andReturn：最后返回相应的MvcResult；然后进行自定义验证/进行下一步的异步处理；
	 * mockMvc.perform(get("/person/list?p=2&s=2")).andExpect(status().isOk()).andDo(print())
	 * .andReturn();
	 */
	@Test
	public void testPersonActionList() throws Exception {
		//模拟请求提交
		mockMvc.perform(get("/person/list?p=1&s=3")).andExpect(status().isOk()).andDo(print());
	}

	@Test
	public void testPersonActionDel() throws Exception {
		
	}
}
