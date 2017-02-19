package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by willfuger on 2/19/17.
 */
@RestController
@RequestMapping("/json/responses")
public class JsonResponsesController {

    @GetMapping("/post")
    public Post getPost() {
        Post post = new Post();
        post.setAuthor("Some Guy");
        post.setContent("I like to troll people trollalalala");
        return post;
    }

}
