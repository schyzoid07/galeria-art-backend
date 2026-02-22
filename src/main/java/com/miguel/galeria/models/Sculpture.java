package com.miguel.galeria.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Table(name = "sculpture")
@PrimaryKeyJoinColumn(name = "id_obra")
@EqualsAndHashCode(callSuper = true)
@Data
public class Sculpture extends Art {
    private String material;
    private Double peso;
    private Double largo;
    private Double ancho;
    private Double profundidad;
}