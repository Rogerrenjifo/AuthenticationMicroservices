package com.sinplu.iopautorizacion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

// @Configuration
// public class UserConfig {
//     @Bean
//     public UserDetailsService userDetailsService() {
//         UserDetails userDetails = User.withUsername("user")
//                 .password("password")
//                 .roles("USER")
//                 .authorities("read")
//                 .build();

//         return new InMemoryUserDetailsManager(userDetails);
//     }
// }
