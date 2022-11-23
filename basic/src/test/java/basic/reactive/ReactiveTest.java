package basic.reactive;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ReactiveTest {

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

}
