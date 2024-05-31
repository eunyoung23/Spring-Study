package com.example.webflux.FluxMono;

import com.example.webflux.utils.Logger;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class HelloReactor{
    public static void main(String[] args) {
        Mono.just("Hello Reactor")
                .subscribe(message -> System.out.println(message));

        Flux<String> sequence2 = Flux.just("Hello","Reactor");
        sequence2
                .map(data -> data.toLowerCase())
                .subscribe(data -> Logger.onNext(data));

    }
}
