package com.sinplu.iopresource.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sinplu.iopresource.entity.Usuario;

import java.util.List;
import java.util.UUID;
import java.util.Map;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query(value = "SELECT u.* FROM usuarios u " +
    "INNER JOIN usuarios_roles ur ON u.id_usuario = ur.fid_usuario " +
    "WHERE u.estado = 'ACTIVO' AND ur.estado = 'ACTIVO'  " +
    "AND ( u.complemento_documento IS NULL  OR u.complemento_documento = '' OR u.complemento_documento = '-' " +
    "OR u.complemento_documento = :documentoIdentidad OR u.complemento_documento = CONCAT(u.documento_identidad, '-', :documentoIdentidad));", nativeQuery = true)
List<Usuario> findUsuariosByDocumentoIdentidadOrderByFechaCreacionDesc(@Param("documentoIdentidad") String documentoIdentidad);

default Usuario findUsuarioMasRecienteByDocumentoIdentidad(String documentoIdentidad, String complementoDocumento) {
    List<Usuario> usuarios = findUsuariosByDocumentoIdentidadOrderByFechaCreacionDesc(documentoIdentidad);
    if (!usuarios.isEmpty()) {
        return usuarios.get(0); // Devuelve el primer usuario de la lista, que tiene la fecha de creación más reciente
    }
    return null; // No se encontraron usuarios con el documento y complemento proporcionados
}



    @Query(value = "SELECT u.id_usuario, u.documento_identidad, u.complemento_documento,concat (u.nombres,' ',  " +
    "u.primer_apellido,' ', u.segundo_apellido) AS nombreCompleto, u.estado AS estatoUsuario, " +
    "ur.id_usuario_rol, ur.clave_usuario, ur.estado AS estadoUsuarioRol, ur.rol, " +
    "ur.estado as estadoUsuarioRol,ur.rol, ur.fid_entidad  " +
    "FROM usuarios u " +
    "INNER JOIN usuarios_roles ur ON u.id_usuario = ur.fid_usuario " +
    "INNER JOIN entidades e ON e.id_entidad = ur.fid_entidad " +
    "WHERE e.id_entidad = :fidEntidad AND ur.rol = 'USUARIO FINAL'", nativeQuery = true)
List<Map<String, Object> > findAllUsuariosFinales(@Param("fidEntidad") UUID fidEntidad);


@Query(value = "SELECT u.id_usuario, u.documento_identidad, u.complemento_documento, " +
    " CONCAT(u.nombres, ' ', u.primer_apellido, ' ', u.segundo_apellido) AS nombreCompleto, " +
    "u.estado AS estadoUsuario, ur.id_usuario_rol, ur.clave_usuario, " +
    "ur.estado AS estadoUsuarioRol, e.id_entidad, e.cantidad_consultas, " +
    "e.clave_entidad,  e.estado AS estadoEntidad, e.nombre_entidad  " +
    "FROM usuarios u  " +
    " INNER JOIN usuarios_roles ur ON u.id_usuario = ur.fid_usuario " +
    "INNER JOIN entidades e ON ur.fid_entidad = e.id_entidad " +
    " where u.documento_identidad = :documentoIdentidad and u.estado = 'ACTIVO' and e.estado = 'ACTIVO';", nativeQuery = true)
    List<Usuario> findByDocumentoIdentidad(@Param("documentoIdentidad") String documentoIdentidad);

}
