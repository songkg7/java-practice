package com.example.springmvc.model.output;

import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming
public record UnitedRecord(int result) {
}
