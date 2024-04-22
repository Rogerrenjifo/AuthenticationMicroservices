package com.sinplu.iopresource.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.data.jpa.repository.Query; 
import org.springframework.data.repository.query.Param;

import com.sinplu.iopresource.entity.Entidad;



public interface EntidadRepository extends JpaRepository<Entidad, UUID> {

 
    // @Query("select e from Entidad e where e.nombreEntidad = :nombreEntidad and e.estado = 'ACTIVO'") 
    // Entidad findEntidadByNombreEntidad(@Param("nombreEntidad") String nombreEntidad);
    @Query("SELECT e FROM Entidad e WHERE e.nombreEntidad = :nombreEntidad AND e.estado = 'ACTIVO'")
    Optional<Entidad> findByNombreEntidad(String nombreEntidad); // Devuelve la entidad directamente

    Optional<Entidad> findOptionalByNombreEntidad(String nombreEntidad); 


   @Query("select e from Entidad e where e.idEntidad = :idEntidad") 
   Optional<Entidad> findEntidadByIdEntidad(@Param("idEntidad") UUID idEntidad); 
}
