package com.example;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by willfuger on 2/18/17.
 */
@RestController
public class FormDataController {

    @PostMapping("/raw")
    public String getRawString(@RequestBody String rawBody) {
        return rawBody;
    }

    @PostMapping(value = "/map", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String showFormData(@RequestParam Map<String, String> body) {
        return String.format("%s said %s!", body.get("author"), body.get("content"));
    }

    @PostMapping(value = "/custom/obj", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String getCustomObjectData(CustomFormData body) {
        return String.format("some value: %s, another value: %s", body.getSomeVal(), body.getAnotherVal());
    }

}
