package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by willfuger on 2/17/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(PagesController.class)
public class PageControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testHomepage() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/hello");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("Hello world"));
    }

    @Test
    public void testPatch() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.patch("/im/a/patch");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("booya"));
    }

    @Test
    public void testDelete() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.delete("/im/a/delete");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("deleted"));
    }

    @Test
    public void testReqParams() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/somepath/with/querystring?param=woah");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("The param is : woah"));
    }

    @Test
    public void testParamsHashMap() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/anotherpath/with/querystring?amicool=true&isspringawesome=ithinkso");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("{amicool=true, isspringawesome=ithinkso}"));
    }

    @Test
    public void testParamCustomObj() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/path/querystring/custom?aParam=123&aDifferentParam=456");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("a param is 123; a different param is 456"));
    }
}


