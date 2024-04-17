package com.sinplu.iopclient;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
// @RequestMapping
public class controller {
    @GetMapping("/")
    public Map<String, String> getMethodName() {
        return Map.of("message", "heññp");
    }

    @GetMapping("/authorized")
    public Map<String, String> getMethodName2(@RequestParam String code) {
        return Collections.singletonMap("authorizationCode", code);
    }

}
