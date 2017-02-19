package com.example;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by willfuger on 2/19/17.
 */
@RestController

public class AllRequestDataController {
    @PostMapping("/posts/{postId}/comments")
    public String getComments(@PathVariable int postId, @RequestBody Comment comment, @RequestParam Map<String, String > params) {
        return String.format(
            "postId: %d, notify: %s, content: %s, author: %s",
            postId,
            params.get("notify"),
            comment.getContent(),
            comment.getAuthor()
        );
    }
}
