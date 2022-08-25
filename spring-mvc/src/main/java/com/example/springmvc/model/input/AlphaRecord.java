package com.example.springmvc.model.input;

import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming
public record AlphaRecord(
        int first,
        int second
) {
}
