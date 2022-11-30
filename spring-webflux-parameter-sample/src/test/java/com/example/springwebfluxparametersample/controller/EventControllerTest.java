package com.example.springwebfluxparametersample.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.util.UriComponentsBuilder;

@WebFluxTest
class EventControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void helloEvent() {
        var uri = UriComponentsBuilder.fromUriString("/event")
                .queryParam("name", "Spring")
                .queryParam("time", "2021-08-01T12:00:00Z")
                .queryParam("anotherTime", "2021-08-01T12")
                .build()
                .toUri();

        webTestClient.get()
                .uri(uri)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.name").isEqualTo("Spring")
                .jsonPath("$.time").isEqualTo("2021-08-01T12:00:00")
                .jsonPath("$.anotherTime").isEqualTo("2021-08-01T12:00:00");
    }

}
