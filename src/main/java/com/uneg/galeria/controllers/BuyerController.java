package com.uneg.galeria.controllers;

import com.uneg.galeria.models.Buyer;
import com.uneg.galeria.services.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/buyers")
@CrossOrigin(origins = "http://localhost:3000")
public class BuyerController {

    @Autowired
    private BuyerService buyerService;

    // 1. Registro de Comprador
    @PostMapping("/register")
    public ResponseEntity<Buyer> register(@RequestBody Buyer buyer) {
        try {
            Buyer nuevoComprador = buyerService.registrarComprador(buyer);
            return new ResponseEntity<>(nuevoComprador, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    // 2. Procesar Pago de Membresía ($10.00)
    // Recibimos un mapa con el metodoPago para mayor flexibilidad
    @PostMapping("/{id}/pay-membership")
    public ResponseEntity<String> payMembership(@PathVariable Long id, @RequestBody Map<String, String> request) {
        String metodoPago = request.get("metodoPago");
        boolean exito = buyerService.procesarPagoMembresia(id, metodoPago);

        if (exito) {
            return ResponseEntity.ok("Pago procesado. El código de seguridad ha sido generado.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No se pudo procesar el pago.");
        }
    }

    // 3. Recuperar Código de Seguridad (Validando las 3 respuestas)
    @PostMapping("/recover-code")
    public ResponseEntity<String> recoverCode(@RequestBody Map<String, Object> request) {
        String email = (String) request.get("email");
        List<String> respuestas = (List<String>) request.get("respuestas");

        try {
            String codigo = buyerService.recuperarCodigoSeguridad(email, respuestas);
            return ResponseEntity.ok(codigo);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }

    // 4. Login simple para Comprador
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        return buyerService.buscarPorLogin(credentials.get("login"))
                .filter(b -> b.getPassword().equals(credentials.get("password"))) // En prod usar BCrypt
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    }
    //5. para admins, obtener todos los compradores
    @GetMapping
    public List<Buyer> getAllBuyers() {
        return buyerService.findAll(); // O el método que tengas en tu service para listar
    }
}