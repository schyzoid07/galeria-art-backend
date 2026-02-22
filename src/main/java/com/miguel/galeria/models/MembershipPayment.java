package com.miguel.galeria.models;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "membership_payment")
@Data
public class MembershipPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_comprador", nullable = false)
    private Buyer comprador;

    @Column(nullable = false)
    private Double monto = 10.0;

    @Column(name = "fecha_pago")
    private LocalDateTime fechaPago = LocalDateTime.now();

    @Column(name = "metodo_pago")
    private String metodoPago; // Ej: "Tarjeta de Crédito"
}