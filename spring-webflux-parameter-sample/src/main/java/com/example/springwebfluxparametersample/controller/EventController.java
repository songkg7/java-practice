package com.example.springwebfluxparametersample.controller;

import com.example.springwebfluxparametersample.domain.Event;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    @GetMapping("/event")
    public Event helloEvent(Event event) {
        return event;
    }

}
