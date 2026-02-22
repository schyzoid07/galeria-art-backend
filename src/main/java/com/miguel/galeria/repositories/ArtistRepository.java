package com.miguel.galeria.repositories;

import com.miguel.galeria.models.Artist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long> {

    // Buscar artista por nombre
    Optional<Artist> findByNombre(String nombre);
}