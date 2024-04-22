package com.sinplu.iopautorizacion.users;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service

public class MyUserDetailService implements UserDetailsService{
    // private final MyUserDetail userDetail;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        UserDto user = new UserDto();
        return new MyUserDetail(user);
    }
    
}
