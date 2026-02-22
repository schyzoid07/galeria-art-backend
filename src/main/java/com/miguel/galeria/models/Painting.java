package com.miguel.galeria.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Table(name = "painting")
@PrimaryKeyJoinColumn(name = "id_obra")
@Data
@EqualsAndHashCode(callSuper = true)
public class Painting extends Art {
    private String tecnica; // Ej: Óleo, Acrílico
    private String estilo;  // Ej: Realismo, Impresionismo
}
