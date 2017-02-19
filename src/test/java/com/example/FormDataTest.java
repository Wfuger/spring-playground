package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.Random;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by willfuger on 2/18/17.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(FormDataController.class)
public class FormDataTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testRawString() throws Exception {
        MockHttpServletRequestBuilder request = post("/raw")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("afield", "value");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("afield=value"));
    }

    @Test
    public void testMap() throws Exception {
        String content = String.valueOf(new Random().nextInt());

        MockHttpServletRequestBuilder request = post("/map")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("content", content)
                .param("author", "Dwayne");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("Dwayne said %s!", content)));

    }

    @Test
    public void testCustomObjForm() throws Exception {
        MockHttpServletRequestBuilder request = post("/custom/obj")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("someVal", "imavalue")
                .param("anotherVal", "anotherValue");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("some value: imavalue, another value: anotherValue"));
    }

}
