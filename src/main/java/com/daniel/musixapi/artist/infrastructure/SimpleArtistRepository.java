package com.daniel.musixapi.artist.infrastructure;

import com.daniel.musixapi.artist.domain.ArtistRepository;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class SimpleArtistRepository implements ArtistRepository {

    public SimpleArtistRepository() {
    }

    @Override
    public String search(Long id, String mbid) {

        /*
        TODO - Mono & FLux class -> Artist class ??
         */

        HttpClient httpClient = HttpClient.create()
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .responseTimeout(Duration.ofMillis(5000))
                .doOnConnected(conn ->
                        conn.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS))
                                .addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS)));

        WebClient webClient = WebClient.builder()
                .baseUrl("https://api.musixmatch.com/ws/1.1/")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();


        // Apikey personal.
        return webClient.get()
                .uri("artist.get?apikey=??&artist_id=118")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
