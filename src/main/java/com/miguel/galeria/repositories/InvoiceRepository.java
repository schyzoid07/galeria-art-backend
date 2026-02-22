package com.miguel.galeria.repositories;



import com.miguel.galeria.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    // 1. Listado de obras vendidas en un periodo dado
    // Esta consulta busca todas las facturas entre dos fechas
    List<Invoice> findByFechaVentaBetween(LocalDateTime inicio, LocalDateTime fin);

    // 2. Buscar facturas de un comprador específico
    List<Invoice> findByCompradorId(Long compradorId);

    // 3. Consulta para el "Resumen de Facturación" (Requerimiento del PDF)
    // Aunque findByFechaVentaBetween trae los datos, a veces es útil
    // una consulta personalizada si quieres cálculos directos de BD.
    @Query("SELECT i FROM Invoice i WHERE i.fechaVenta >= :inicio AND i.fechaVenta <= :fin")
    List<Invoice> obtenerResumenFacturacion(@Param("inicio") LocalDateTime inicio,
                                            @Param("fin") LocalDateTime fin);
}
