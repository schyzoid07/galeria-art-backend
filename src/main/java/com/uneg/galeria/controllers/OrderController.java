package com.uneg.galeria.controllers;

import com.uneg.galeria.models.Invoice;
import com.uneg.galeria.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private InvoiceService invoiceService; // El que creamos antes

    @PostMapping("/purchase")
    public ResponseEntity<String> purchaseArt(@RequestBody Map<String, Object> request) {
        try {
            // Extraemos los IDs del JSON que enviaste en Thunder Client
            Long obraId = Long.valueOf(request.get("obraId").toString());
            Long compradorId = Long.valueOf(request.get("compradorId").toString());

            // Aquí llamamos a la lógica para generar la factura
            // Nota: El service debe validar que la obra esté 'Disponible'
            boolean exito = invoiceService.registrarVenta(obraId, compradorId);

            if (exito) {
                return ResponseEntity.ok("Compra exitosa. Factura generada.");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                        .body("La obra no está disponible o los datos son incorrectos.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al procesar la compra: " + e.getMessage());
        }
    }
}
