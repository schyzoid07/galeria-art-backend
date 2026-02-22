package com.uneg.galeria.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Entity
@Table(name = "ceramic")
@PrimaryKeyJoinColumn(name = "id_obra")
@Data
@EqualsAndHashCode(callSuper = true)
public class Ceramic extends Art {
    @Column(name = "tipo_arcilla")
    private String tipoArcilla; // Ej: Gres, Porcelana

    @Column(name = "temperatura_coccion")
    private Double temperaturaCoccion; // En grados Celsius
}