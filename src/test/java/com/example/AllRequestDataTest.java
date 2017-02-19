package com.example;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by willfuger on 2/19/17.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(AllRequestDataController.class)
public class AllRequestDataTest {

    private Gson gson = new GsonBuilder().create();
    @Autowired
    private MockMvc mvc;

    @Test
    public void testAllRequests() throws Exception {
        Comment comment = new Comment();
        comment.setAuthor("Rick James");
        comment.setContent("I'm Rick James ******");
        MockHttpServletRequestBuilder request = post("/posts/32/comments?notify=true")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(comment));
        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(String.format(
                        "postId: 32, notify: %s, content: %s, author: %s",
                        "true",
                        comment.getContent(),
                        comment.getAuthor()
                )));
    }
}
