package com.example.webflux.Scheduler;

import com.example.webflux.utils.Logger;
import lombok.extern.java.Log;
import reactor.core.publisher.Flux;

/**
 * Sequence의 Operator 체인에서 최초의 스레드는 subscribe()가
 * 호출되는 scope에 있는 스레드이다.
 */
public class SchedulerOperatorExample01 {
    public static void main(String[] args) {
        Flux.fromArray(new Integer[]{1,3,5,7,9})
                .filter(data -> data > 3)
                .map(data -> data * 10)
                .subscribe(Logger::onNext);
    }
}
