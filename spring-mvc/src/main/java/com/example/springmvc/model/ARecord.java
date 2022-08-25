package com.example.springmvc.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ARecord(
        @JsonProperty String name,
        @JsonProperty int age
) implements Model {
}
