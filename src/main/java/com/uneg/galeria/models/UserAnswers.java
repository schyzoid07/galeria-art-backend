package com.uneg.galeria.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "user_answers")
@Data
public class UserAnswers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private SecurityQuestion pregunta;

    @Column(nullable = false, length = 255)
    private String respuesta;
}