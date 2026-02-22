package com.miguel.galeria.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "orphebrery") // Nombre exacto del diagrama
@PrimaryKeyJoinColumn(name = "id_obra")
@Data
@EqualsAndHashCode(callSuper = true)
public class Orphebrery extends Art {

    @Column(name = "pureza_metal")
    private String purezaMetal; // Ej: "18K", "Plata 950"

    private Double peso; //

    @Column(name = "metal_base")
    private String metalBase; // Ej: "Oro", "Plata"
}