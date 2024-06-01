package com.example.webflux.Sinks;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.util.stream.IntStream;

/**
 * Sinks를 사용하는 예제
 * - publisher의 데이터 생성을 멀티 스레드에서 진행해도 thread safe하다.
 */
@Slf4j
public class ProgrammaticSinkExample01 {
    public static void main(String[] args) throws InterruptedException {
        int tasks = 6;

        Sinks.Many<String> unicastSink = Sinks.many().unicast().onBackpressureBuffer();
        Flux<String> fluxView = unicastSink.asFlux();
        IntStream
                .range(1, tasks)
                .forEach(n -> {
                    try {
                        new Thread(() -> {
                            unicastSink.emitNext(doTask(n), Sinks.EmitFailureHandler.FAIL_FAST);
                            log.info("# emitted: {}", n);
                        }).start();
                        Thread.sleep(100L);
                    } catch (InterruptedException e) {}
                });

        fluxView
//                .publishOn(Schedulers.parallel())
//                .map(result -> result + " success!")
//                .doOnNext(n -> log.info("# map(): {}", n))
//                .publishOn(Schedulers.parallel())
                .subscribe(data -> log.info("# onNext: {}",data));

        Thread.sleep(2000);
    }

    private static String doTask(int taskNumber){
        //now tasking
        //complete to task
        return "task" + taskNumber +" result";
    }
}
