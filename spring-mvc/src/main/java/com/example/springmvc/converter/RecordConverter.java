package com.example.springmvc.converter;

import com.example.springmvc.model.output.UnitedRecord;

@FunctionalInterface
public interface RecordConverter {

    UnitedRecord convert();

}
