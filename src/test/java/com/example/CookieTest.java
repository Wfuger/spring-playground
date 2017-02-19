package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.Cookie;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by willfuger on 2/19/17.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(CookieController.class)
public class CookieTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testCookies() throws Exception {
        this.mvc.perform(get("/cookie/monster").cookie(new Cookie("foo", "bar")))
                .andExpect(status().isOk())
                .andExpect(content().string("bar"));
    }

}
