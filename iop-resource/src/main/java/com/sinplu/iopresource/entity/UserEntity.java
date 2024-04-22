package com.sinplu.iopresource.entity;

import java.util.Set;
import java.util.UUID;

import org.springframework.context.annotation.FilterType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Singular;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "userr")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idUser;

    @Column(name = "ci_number")
    private String documentNumberId;

    @Column(name = "password")
    private String password;

    // @JoinTable(name = "user_authorities",
    //        joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
    //        inverseJoinColumns = @JoinColumn(name = "authorities_id", referencedColumnName = "id"))
    @Column(name = "authorities")
    private Set<String> authorities;

}
