package com.daniel.musixapi.artist.application.search;

import com.daniel.musixapi.artist.domain.ArtistRepository;

public class ArtistSearcher {

    private final ArtistRepository artistRepository;

    public ArtistSearcher(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    public String getSpecificArtist (Long id, String mbid) {
        return artistRepository.search(id, mbid);
    }

}
