package com.sinplu.iopresource.controller;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinplu.iopresource.dto.UserDto;
import com.sinplu.iopresource.entity.UserEntity;
import com.sinplu.iopresource.repository.UserRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping
public class UsuarioController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{userci}")
    public Optional<UserEntity> getUser(@PathVariable String userci) {
        return userRepository.findByDocumentNumberId(userci);
    }
    @PostMapping("/user")
    public UserEntity getAllUsers(@RequestBody UserDto user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setPassword(user.getPassword());
        userEntity.setDocumentNumberId(user.getDocumentNumberId());
        userEntity.setAuthorities(Set.of("ADMIN"));
        userEntity = userRepository.save(userEntity);
        return userEntity;

    }
    
}
