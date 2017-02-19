package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * Created by willfuger on 2/19/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(JsonResponsesController.class)
public class JsonResponsesTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testPostJsonResponse() throws Exception {
        this.mvc.perform(
                get("/json/responses/post")
                        .accept(MediaType.APPLICATION_JSON_UTF8)
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.author", is("Some Guy")))
                .andExpect(jsonPath("$.content", is("I like to troll people trollalalala")));
    }
}
