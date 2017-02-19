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

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by willfuger on 2/18/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(JsonController.class)
public class JsonTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testStringJSON() throws Exception {
        MockHttpServletRequestBuilder request = post("/json/string")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"John Doe\", \"age\": \"23\"}");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("{name: John Doe, age: 23}"));
    }

    private Gson gson = new GsonBuilder().create();

    @Test
    public void testGsonJSON() throws Exception {

        Post post = new Post();
        post.setAuthor("BillyBob");
        post.setContent("I'm a post this is my content blah blah blah");


        MockHttpServletRequestBuilder request = post("/json/gson")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(post));

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("Post made by %s, content is %s", post.getAuthor(), post.getContent())));
    }

    @Test
    public void testFileJSON() throws Exception {

        String json = getJSON("/data.json");

        MockHttpServletRequestBuilder request = post("/json/file")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("The dude abides"));
    }

    private String getJSON(String path) throws Exception {
        URL url = this.getClass().getResource(path);
        return new String(Files.readAllBytes(Paths.get(url.getFile())));
    }
}
