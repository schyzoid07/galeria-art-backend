package com.uneg.galeria.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Table(name = "photograph")
@PrimaryKeyJoinColumn(name = "id_obra")
@Data
@EqualsAndHashCode(callSuper = true)
public class Photograph extends Art {
    @Column(name = "tipo_impresion")
    private String tipoImpresion; // Ej: Inyección de tinta, Giclée

    private String papel; // Ej: Papel de algodón, Brillo

    private String edicion; // Ej: "1 de 10" para indicar exclusividad
}