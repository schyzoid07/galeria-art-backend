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
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private InvoiceService invoiceService;

    @PostMapping("/purchase")
    public ResponseEntity<?> purchaseArt(@RequestBody Map<String, Object> request) {
        try {
            // Extraemos los datos exactos que pide el método crearFactura
            Long obraId = Long.valueOf(request.get("obraId").toString());
            Long compradorId = Long.valueOf(request.get("compradorId").toString());
            Long adminId = Long.valueOf(request.get("adminId").toString());
            String codigoSeguridad = (String) request.get("codigoSeguridad");
            String direccion = (String) request.get("direccion");

            // Llamada al método original
            Invoice factura = invoiceService.crearFactura(obraId, compradorId, adminId, codigoSeguridad, direccion);

            return ResponseEntity.ok(factura); // Devolvemos la factura completa en JSON
        } catch (RuntimeException e) {
            // Aquí capturamos los "throw new RuntimeException" (Membresía no paga, código inválido, etc.)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }
}