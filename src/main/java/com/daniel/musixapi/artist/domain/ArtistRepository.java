package com.daniel.musixapi.artist.domain;

public interface ArtistRepository {

    public Artist search (final Long id, final String mbid);

}
