package com.example.webflux.Backpressure;

import com.example.webflux.utils.Logger;
import com.example.webflux.utils.TimeUtils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

/**
 * Unbouded request 할 경우, Downstream에 Backpressure Latest 전략을 적용하는 예제
 * - Downstream으로 전달 할 데이터가 버퍼에 가득 찰 경우,
 *  버퍼 밖에서 폐기되지 않고 대기하는 가장 나중엨(최근에) emit한 데이터부터 버퍼에 채우는 전략
 */
public class BackpressureStreategyLatestExample {
    public static void main(String[] args) {
        Flux
                .interval(Duration.ofMillis(1L))
                .onBackpressureLatest()
                .publishOn(Schedulers.parallel())
                .subscribe(data -> {
                            TimeUtils.sleep(5L);
                            Logger.onNext(data);
                        },
                        error -> Logger.onError(error));

        TimeUtils.sleep(2000L);
    }
}
