package com.example.springmvc.model.input;

import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming
public record BetaRecord(int first, int second, int third) {
}
