package com.sinplu.iopresource.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinplu.iopresource.entity.AuthorityEntity;

public interface AuthorityRepository extends JpaRepository<AuthorityEntity, Integer>{
    
}
