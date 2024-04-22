package com.sinplu.iopresource.entity;

import java.sql.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "usuarios_roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRol {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_usuario_rol")
    private UUID idUsuarioEntidad;

    @Column(name = "estado")
    private String estado;

    @Column(name = "rol")
    private String rol;

    @Column(name = "clave_usuario")
    private String claveUsuario;

    @Column(name = "complemento_documento")
    private String complementoDocumento;

    @Column(name = "_usuario_creacion")
    private Integer usuarioCreacion;

    @Column(name = "_usuario_modificacion")
    private Integer usuarioModificacion;

    @Column(name = "_fecha_creacion")
    private Date fechaCreacion;

    @Column(name = "_fecha_modificacion")
    private Date fechaModificacion;

    @ManyToOne
    @JoinColumn(name = "fid_usuario")
    private Usuario fidUsuario;

    @ManyToOne
    @JoinColumn(name = "fid_entidad")
    private Entidad fidEntidad;

    @PrePersist
    public void prePersist() {
        this.estado = "ACTIVO";
        this.fechaCreacion = new Date(System.currentTimeMillis());
    }
}

