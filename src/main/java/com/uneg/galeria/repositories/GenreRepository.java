package com.uneg.galeria.repositories;

import com.uneg.galeria.models.Genre; // O Genero
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

    // Para buscar por nombre exacto si es necesario
    Optional<Genre> findByNombreIgnoreCase(String nombre);
}
