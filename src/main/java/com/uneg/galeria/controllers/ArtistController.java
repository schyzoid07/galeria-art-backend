package com.uneg.galeria.controllers;

import com.uneg.galeria.models.Artist;
import com.uneg.galeria.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/artistas")
@CrossOrigin(origins = "http://localhost:3000")
public class ArtistController {

    @Autowired
    private ArtistService artistService;

    @GetMapping
    public List<Artist> getAll() {
        return artistService.getAllArtists();
    }
}