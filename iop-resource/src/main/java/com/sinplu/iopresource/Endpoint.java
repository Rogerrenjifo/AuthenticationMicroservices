package com.sinplu.iopresource;

import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/resources")
public class Endpoint {
    @GetMapping("/authorities")
    public Map<String, Object> getMethodName(Authentication authentication) {
        return Map.of("message", authentication.getPrincipal());
    }
    @GetMapping("/method")
    // @PreAuthorize("hasAuthority('read')")
    @PreAuthorize("hasAuthority('SCOPE_openid')")
    public Map<String, Object> controlMethod(Authentication authentication) {
        return Map.of("message", authentication.getPrincipal());
    }

}
