package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by willfuger on 2/18/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(PathVariableController.class)
public class PathVariableTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getIndividualParams() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/individual/blahblah/123");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("q:blahblah id:123"));
    }

    @Test
    public void getHashMapParams() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/map/191/anotherthing/002");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("{mapId=191, anotherthingId=002}"));
    }

    @Test
    public void getCustObjParams() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/posts/28673/comments/234978");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("post id is 28673; comment id is 234978"));

    }
}