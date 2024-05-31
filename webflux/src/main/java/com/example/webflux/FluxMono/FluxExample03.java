package com.example.webflux.FluxMono;

import com.example.webflux.utils.Logger;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * 2개의 MONO를 연결해서 FLUX로 변환하는 예제
 */
public class FluxExample03 {
    public static void main(String[] args) {
        Flux<Object> flux = Mono.justOrEmpty(null)
                .concatWith(Mono.justOrEmpty("Jobs"));
        flux.subscribe(data -> Logger.info("# result: {}",data));
    }
}
