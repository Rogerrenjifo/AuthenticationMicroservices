package com.sinplu.iopresource.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sinplu.iopresource.entity.UsuarioRol;


public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, UUID> {

}

