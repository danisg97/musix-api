package com.daniel.musixapi.artist.application.search;

import com.daniel.musixapi.artist.domain.Artist;
import com.daniel.musixapi.artist.domain.ArtistRepository;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class ArtistSearcher {

    private ArtistRepository artistRepository;

    public ArtistSearcher(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    // TODO - Continuar
    @GetMapping("https://api.musixmatch.com/ws/1.1/artist.get?artist_id={id}")
    public Artist getSpedificArtist (@PathVariable Long id, @Nullable @PathVariable String mbid) {
        return artistRepository.search(id, mbid);
    }

}
