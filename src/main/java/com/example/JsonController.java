package com.example;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by willfuger on 2/18/17.
 */
@RestController
@RequestMapping("/json")
public class JsonController {

    @PostMapping("/string")
    public String getJsonString(@RequestBody Person person) {
        return String.format("{name: %s, age: %s}", person.getName(), person.getAge());
    }

    @PostMapping("/gson")
    public String getGsonJson(@RequestBody Post post) {
        System.out.println(post);
        return String.format("Post made by %s, content is %s", post.getAuthor(), post.getContent());
    }

    @PostMapping("/file")
    public String getFileJson(@RequestBody Blog blog) {
        return blog.getArticles()[0].getComments()[1].getContent();
    }
}
