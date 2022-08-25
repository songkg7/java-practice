package com.example.springmvc.converter;

import com.example.springmvc.model.input.AlphaRecord;
import com.example.springmvc.model.output.UnitedRecord;

public class AlphaConverter implements RecordConverter {

    private final AlphaRecord model;

    public AlphaConverter(AlphaRecord model) {
        this.model = model;
    }

    @Override
    public UnitedRecord convert() {
        return new UnitedRecord(model.first() + model.second());
    }
}
