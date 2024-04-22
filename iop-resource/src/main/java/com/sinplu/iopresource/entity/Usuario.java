package com.sinplu.iopresource.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario")
    private Integer idUsuario;

    @Column
    private String estado;

    @Column(name = "nombres")
    private String nombres;

    @Column(name = "primer_apellido")
    private String primerApellido;

    @Column(name = "segundo_apellido")
    private String segundoApellido;

    @Column(name = "documento_identidad")
    private String documentoIdentidad;

    @Column(name = "complemento_documento")
    private String complementoDocumento;

    @Column(name = "_usuario_creacion")
    private Integer usuarioCreacion;

    @Column(name = "_usuario_modificacion")
    private Integer usuarioModificacion;

    @Column(name = "_fecha_creacion")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime fechaCreacion;

    @Column(name = "_fecha_modificacion")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private LocalDateTime fechaModificacion;
    // Getters y Setters omitidos por brevedad

    @PrePersist
    public void prePersist() {
        this.estado = "ACTIVO";
        this.fechaCreacion = LocalDateTime.now();
        this.fechaModificacion = LocalDateTime.now();
    }

}
