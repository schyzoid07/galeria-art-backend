package com.miguel.galeria.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "security_question")
@Data
public class SecurityQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String pregunta; // Ej: ¿Nombre de tu primera mascota?
}
