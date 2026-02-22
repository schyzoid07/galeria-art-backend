package com.uneg.galeria.models;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "genre")
@Data
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 50)
    private String nombre; // Ej: Pintura, Escultura, etc.
}