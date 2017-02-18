package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by willfuger on 2/18/17.
 */
@RestController
public class PathVariableController {

    @GetMapping("individual/{query}/{id}")
    public String getIndividualVariables(@PathVariable int id , @PathVariable("query") String query) {
        return String.format("q:%s id:%d", query, id);
    }

    @GetMapping("map/{mapId}/anotherthing/{anotherthingId}")
    public String getHashMapVariables(@PathVariable Map pathVariables) {
        return pathVariables.toString();
    }

    @GetMapping("posts/{postId}/comments/{commentId}")
    public String getCustomObjVariables(CustomVariableObj ids) {
        return String.format("post id is %d; comment id is %d", ids.getPostId(), ids.getCommentId());
    }
}
