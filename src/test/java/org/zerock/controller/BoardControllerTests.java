package org.zerock.controller;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml","file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@Log4j
public class BoardControllerTests {

	@Setter(onMethod_=@Autowired)
	private WebApplicationContext ctx;
	
	private MockMvc mockMvc;
	
	//테스트실행마다 실행되는
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testList() {
		try {
			ModelAndView result = mockMvc.perform(
							MockMvcRequestBuilders.post("/board/remove")
							.param("bno", "10")
//							.param("title", "새글테스트")
//							.param("content", "새글내용")
							//.param("writer", "새글작성자"))
							).andReturn()//MvcResult
							.getModelAndView();//ModelAndView
							//.getModelMap();//ModelMap
			log.info(result);
//			Set<String> set = result.keySet();
//			for(String key : set) {
//				log.info("key: "+key+", val: "+ result.get(key));
//			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
