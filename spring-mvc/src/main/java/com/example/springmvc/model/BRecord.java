package com.example.springmvc.model;

import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming
public record BRecord(String name, int age) implements Model {
}
