package com.example.springwebfluxparametersample.controller;

import com.example.springwebfluxparametersample.domain.Event;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class EventController {

    @GetMapping("/event")
    public Mono<Event> helloEvent(Event event) {
        return Mono.just(event);
    }

}
