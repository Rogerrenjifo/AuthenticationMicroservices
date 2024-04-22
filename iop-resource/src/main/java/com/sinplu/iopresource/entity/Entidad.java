package com.sinplu.iopresource.entity;


import java.sql.Date;
import java.time.LocalDate;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
// import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "entidades")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Entidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_entidad")
    private UUID idEntidad;

    @Column(name = "nombre_entidad")
    private String nombreEntidad;

    @Column(name = "estado")
    private String estado;

    @Column(name = "cantidad_consultas")
    private String cantidadConsulta;

    @Column(name = "clave_entidad")
    private String claveEntidad;

    @Column(name = "fecha_inicio", nullable = false)
    // @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaInicio;

    @Column(name = "fecha_fin")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaFin;

    @Column(name = "respaldo_pdf")
    private String respaldoPdf;

    @Column(name = "_usuario_creacion")
    private Integer usuarioCreacion;

    @Column(name = "_usuario_modificacion")
    private Integer usuarioModificacion;

    @Column(name = "usuario_front")
    private Boolean usuarioFront;

    @Column(name = "_fecha_creacion")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaCreacion;

    @Column(name = "_fecha_modificacion")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaModificacion;

    //private String fechaCreacionFormateada;

    @PrePersist
    public void prePersist() {
        this.estado = "ACTIVO";
        this.fechaCreacion = LocalDate.now();
        //this.fechaCreacionFormateada = this.fechaCreacion.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        this.usuarioFront = false;
    }
}

