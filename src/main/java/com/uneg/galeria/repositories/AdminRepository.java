package com.uneg.galeria.repositories;

import com.uneg.galeria.models.Admin; // Importa tu modelo
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    // Para el login del panel administrativo
    Optional<Admin> findByLogin(String login);

    // Para verificar si un admin existe antes de asignarlo a una factura
    boolean existsByLogin(String login);
}