package com.example.webflux.FluxMono;

import com.example.webflux.utils.Logger;
import reactor.core.publisher.Flux;

public class FluxExample04 {
    public static void main(String[] args) {
        Flux.concat(
                        Flux.just("Venus"),
                        Flux.just("Earth"),
                        Flux.just("Mars")
                )
                .collectList()
                .subscribe(planetList-> Logger.info("# Solar System:{} ",planetList));
    }
}
