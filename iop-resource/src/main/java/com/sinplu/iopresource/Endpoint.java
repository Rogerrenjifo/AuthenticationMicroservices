package com.sinplu.iopresource;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/resources")
public class Endpoint {
    @GetMapping
    public Map<String, String> getMethodName(Authentication authentication) {
        return Map.of("message", authentication.getPrincipal().toString());
    }

}
