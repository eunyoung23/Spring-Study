package com.example.webflux.Sequence;

import com.example.webflux.utils.Logger;
import reactor.core.publisher.Flux;

import java.util.Arrays;

public class ColdSequenceExample {
    public static void main(String[] args) {
        Flux<String> coldFlux = Flux.fromIterable(Arrays.asList("RED","YELLOW","PINK"))
                .map(String::toLowerCase);

        coldFlux.subscribe(country -> Logger.info("# subscriber1: {}",country));
        Logger.info("-----------------------------------------------");
        coldFlux.subscribe(country -> Logger.info("# subscriber2: {}",country));

    }
}
