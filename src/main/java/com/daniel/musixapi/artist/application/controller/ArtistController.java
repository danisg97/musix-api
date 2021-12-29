package com.daniel.musixapi.artist.application.controller;

import com.daniel.musixapi.artist.application.search.ArtistSearcher;
import com.daniel.musixapi.artist.domain.ArtistRepository;
import com.daniel.musixapi.artist.infrastructure.SimpleArtistRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArtistController {

    final ArtistRepository artistRepository = new SimpleArtistRepository();
    final ArtistSearcher searcher = new ArtistSearcher(artistRepository);

    @GetMapping("/artist/{id}")
    public String getArtist(@PathVariable Long id, String mbid) {
        return searcher.getSpecificArtist(id, mbid);
    }


}
