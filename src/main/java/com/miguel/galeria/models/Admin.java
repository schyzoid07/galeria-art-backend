package com.miguel.galeria.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;



@Entity
@Table(name = "admin")
@PrimaryKeyJoinColumn(name = "id_usuario")
@Data
@EqualsAndHashCode(callSuper = true)
public class Admin extends User {

    @Column(nullable = false)
    private String cargo;
}