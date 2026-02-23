package com.uneg.galeria.services.impl;

import com.uneg.galeria.models.Art;
import com.uneg.galeria.repositories.ArtRepository;
import com.uneg.galeria.services.ArtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ArtServiceImpl implements ArtService {

    @Autowired
    private ArtRepository artRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Art> obtenerTodasDisponibles() {

        return artRepository.findByEstatusOrderByPrecioBaseAsc("Disponible");
    }

    @Override
    @Transactional(readOnly = true)
    public List<Art> buscarPorGenero(String nombreGenero) {
        return artRepository.findByGeneroNombreIgnoreCaseAndEstatus(nombreGenero, "Disponible");
    }

    @Override
    @Transactional(readOnly = true)
    public List<Art> buscarPorArtista(Long artistaId) {
        return artRepository.findByArtistaId(artistaId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Art> listarPorPrecioMenorAMayor() {
        return artRepository.findByEstatusOrderByPrecioBaseAsc("Disponible");
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Art> obtenerPorId(Long id) {
        return artRepository.findById(id);
    }

    @Override
    @Transactional
    public Art guardarObra(Art obra) {
        return artRepository.save(obra);
    }

    @Override
    @Transactional
    public void eliminarObra(Long id) {
        artRepository.deleteById(id);
    }
}