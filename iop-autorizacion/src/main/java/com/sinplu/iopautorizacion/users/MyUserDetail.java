package com.sinplu.iopautorizacion.users;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MyUserDetail implements UserDetails{
    private final UserDto user;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority adminRole = new SimpleGrantedAuthority("ADMIN");
        SimpleGrantedAuthority finalRole = new SimpleGrantedAuthority("FINAL");
        SimpleGrantedAuthority masterRole = new SimpleGrantedAuthority("MASTER");
        Set<SimpleGrantedAuthority> authorities = Set.of(adminRole, finalRole, masterRole);
        return authorities;
    }

    @Override
    public String getPassword() {
        return "123";
    }

    @Override
    public String getUsername() {
       return "roger";
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
       return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    
}
