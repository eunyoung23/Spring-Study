package com.example.webflux.FluxMono;

import com.example.webflux.utils.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.Collections;

public class MonoExample03 {
    public static void main(String[] args) {
        URI worldTimeuri = UriComponentsBuilder.newInstance().scheme("http")
                .host("worldtimeapi.org")
                .port(80)
                .path("/api/timezone/Asia/Seoul")
                .build()
                .encode()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

        Mono.just(
                        restTemplate.exchange(worldTimeuri, HttpMethod.GET, new HttpEntity<String>(headers),String.class)
                )
                .map(response ->{
                    String dateTime = "";
                    return dateTime;

                })
                .subscribe(
                        data -> Logger.info("# emitted data: {}",data),
                        error -> {},
                        () -> Logger.info("# emitted onComplete signal")
                );

    }
}
