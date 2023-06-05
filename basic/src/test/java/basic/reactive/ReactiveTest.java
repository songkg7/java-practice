package basic.reactive;

import basic.exception.TestException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Hooks;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.assertj.core.api.Assertions.assertThat;

public class ReactiveTest {

    private final Logger log = LoggerFactory.getLogger(ReactiveTest.class);

    @Test
    void subscribe_mono() {
        Mono<String> mono = Mono.just("Hello").doOnSubscribe(result -> {
            System.out.println("subscribe to source");
        });

        mono.subscribe();
        mono.subscribe();
    }

    @Test
    void subscribe_flux() {
        Flux<Integer> flux = Flux.range(1, 3).doOnSubscribe(result -> {
                    System.out.println("subscribe to source");
                })
                .doOnComplete(() -> {
                    System.out.println("complete");
                });

        flux.subscribe(System.out::println,
                e -> {
                },
                () -> {
                });
    }

    @Test
    void mono_getValue() {
        Mono<String> mono = Mono.just("Hello")
                .doOnSubscribe(result -> {
                    System.out.println("subscribe to source");
                });

        mono.subscribe();
    }

    @Test
    @DisplayName("Reactive streams 규격을 지키지 않거나 기준을 따르지 않으면 dropping hook 이 호출된다.")
    void onNextDropped() {
        Hooks.onNextDropped(o -> {
            log.info("onNextDropped: {}", o);
            assertThat(o).isEqualTo(1);
        });

        Mono.from(s -> {
                    s.onComplete(); // complete 를 호출하고
                    s.onNext(1); // onNext 를 호출하면 onNextDropped hook 이 호출된다.
                })
                .subscribe();
    }

    @Test
    @DisplayName("OnNext, OnError, OnComplete 를 실행하는동안 예외가 발생하면 OnOperatorError 가 호출된다.")
    void onOperatorError() {
        Hooks.onOperatorError((throwable, o) -> {
            assertThat(throwable).isInstanceOf(RuntimeException.class);
            assertThat(o).isEqualTo(1);
            return new TestException(throwable);
        });

        Mono<Object> errorMono = Mono.just(1)
                .map(i -> { // onNext 호출
                    throw new RuntimeException();
                });

        StepVerifier.create(errorMono)
                .expectError(TestException.class)
                .verify();
    }

    @Test
    @DisplayName("OnNext, OnError, onComplete 마다 onEachOperator 를 통해 다른 publisher 를 반환할 수 있다.")
    void onEachOperator() {
        Hooks.onEachOperator(objectPublisher -> {
            log.info("onEachOperator: {}", objectPublisher);
            return objectPublisher;
        });

        StepVerifier.create(Mono.just(1).map(i -> i + 1)) // just 로 MonoJust, map 으로 MonoMapFuseable
                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    @DisplayName("onEachOperator 에서 onNext 에 의해 호출되는지 확인")
    void onEachOperator_onNext() {
        Hooks.onEachOperator(objectPublisher -> {
            log.info("onEachOperator: {}", objectPublisher);
            return objectPublisher;
        });

        Flux<Integer> firstFlux = Flux.just(1, 2, 3) // FluxArray publisher
                .map(i -> i + 1); // FluxMapFuseable publisher

        Flux<Integer> secondFlux = Flux.from(firstFlux)
                .doOnNext(i -> log.info("onNext: {}", i)); // FluxPeekFuseable publisher

        StepVerifier.create(secondFlux) // just 로 MonoJust, map 으로 MonoMapFuseable
                .expectNext(2, 3, 4)
                .verifyComplete();
    }

    @Test
    @DisplayName("window")
    void window() {
        var flux = Flux.range(1, 100);

        // skip first and last
        Flux<Integer> skipFirstAndLast = flux
                .skip(1)
                .skipLast(1)
                .map(i -> i * 2)
                .log();

        StepVerifier.create(skipFirstAndLast)
                .expectNextCount(98)
                .verifyComplete();
    }
}
