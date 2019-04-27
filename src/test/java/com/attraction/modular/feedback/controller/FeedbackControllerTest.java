package com.attraction.modular.feedback.controller;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.Test;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringJUnit4ClassRunner.class)     //调用Spring单元测试类
@WebAppConfiguration        //调用Java Web组件，如自动注入ServletContext Bean等
@ContextConfiguration(locations = {"classpath*:springs.xml"})      //加载Spring配置文件
public class FeedbackControllerTest {
    @Autowired
    protected WebApplicationContext wac;

    MockMvc mockMvc;
    // 模拟request,response
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  //初始化MockMvc对象
    }

    @Test
    public void testGetPageFeedback() throws Exception {
//        PageResult pageResult = feedbackController.getPageFeedback(0, 2);

    }

    @Test
    public void testDistributionTask() throws Exception {
    }

    @Test
    public void testDoneTask() throws Exception {
    }

    @Test
    public void testInsertFeedback() throws Exception {

    }

    @Test
    public void testFileUpload() throws Exception {
    }

    public void getAllCategoryTest() throws Exception {
    }
}