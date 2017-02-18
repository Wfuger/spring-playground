package com.example;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

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

    @GetMapping("/somepath/with/querystring")
    public String individualParams(@RequestParam String param) {
        return String.format("The param is : %s", param);
    }

    @GetMapping("/anotherpath/with/querystring")
    public String hashMapParams(@RequestParam Map queryString) {
        return queryString.toString();
    }
    @GetMapping("/path/querystring/custom")
    public String getParamsWCustomObj(CustomQueryObj custObj) {
        return String.format("a param is %s; a different param is %s", custObj.getaParam(), custObj.getaDifferentParam());
    }
}
