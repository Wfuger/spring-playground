package com.example;

import org.springframework.web.bind.annotation.*;

/**
 * Created by willfuger on 2/19/17.
 */
@RestController
@RequestMapping("/cookie")
public class CookieController {

    @GetMapping("/monster")
    public String cookieMonster(@CookieValue(name= "foo") String cookie) {
        return cookie;
    }

}

