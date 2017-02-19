package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by willfuger on 2/19/17.
 */

@RestController
public class HeaderController {

    @GetMapping("/header")
    public String testHeader(@RequestHeader String host) {
        return host;
    }
}