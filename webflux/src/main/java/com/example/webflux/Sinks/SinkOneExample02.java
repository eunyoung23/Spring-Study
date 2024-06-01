package com.example.webflux.Sinks;

import com.example.webflux.utils.Logger;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;

/**
 * Sink.one 예제
 * - 두 건의 데이터만 Emit하는 예제
 */
public class SinkOneExample02 {
    public static void main(String[] args) {
        //emit된 데이터 중에서 단 하나의 데이터만 Subscriber에게 전달한다. 나머지 데이터는 drop됨.
        Sinks.One<String> sinkOne = Sinks.one();
        Mono<String> mono = sinkOne.asMono();

        sinkOne.emitValue("Hello Reactor", Sinks.EmitFailureHandler.FAIL_FAST);

        //Sink.one은 단 한개의 데이터를 emit할 수 있기 때문에 두번째 Emit한 데이터는 drop된다.
        sinkOne.emitValue("Hi Reactor", Sinks.EmitFailureHandler.FAIL_FAST);

        mono.subscribe(data -> Logger.onNext("Subscriber1 ",data));
        mono.subscribe(data -> Logger.onNext("Subscriber2 ",data));
    }
}
