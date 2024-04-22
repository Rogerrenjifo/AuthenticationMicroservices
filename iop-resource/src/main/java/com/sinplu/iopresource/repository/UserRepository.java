package com.sinplu.iopresource.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinplu.iopresource.entity.UserEntity;
import java.util.List;
import java.util.Optional;


public interface UserRepository extends JpaRepository<UserEntity, Integer>{

    Optional<UserEntity> findByDocumentNumberId(String documentNumberId);
}
