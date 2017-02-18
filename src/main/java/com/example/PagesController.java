package com.example;

import org.springframework.web.bind.annotation.*;

/**
 * Created by willfuger on 2/17/17.
 */
@RestController
public class PagesController {

    @GetMapping
    public String sayHello(){
        return "Hello world";
    }
    @PatchMapping("im/a/patch")
    public String doesItWork() {
        return "booya";
    }
    @DeleteMapping("im/a/delete")
    public String deleteMe() {
        return "deleted";
    }
}
