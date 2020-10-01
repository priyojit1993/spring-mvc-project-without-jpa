package com.springlearning.srpingmvc.springmvc;

import com.springlearning.srpingmvc.springmvc.product.controller.IndexController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


public class IndexControllerTest {
    private MockMvc mockMvc;
    private IndexController indexController;

    @Before
    public void setup() {
//        create instance  of index controller
        indexController = new IndexController();

        // use the mockmvc to mock the controller and create an MVC instance


        mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
    }

    @Test
    public void testIndex() throws Exception {
        // we use the mock controller to fire a get request on given url pattern
//        and on successfull execution it will call the corresponding view resolver
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.view().name("index"));
    }
}
