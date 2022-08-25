package com.example.springmvc.policy;

import com.example.springmvc.model.input.BetaRecord;
import com.example.springmvc.model.output.UnitedRecord;

public class BetaConverter implements RecordConverter {

    private final BetaRecord model;

    public BetaConverter(BetaRecord model) {
        this.model = model;
    }

    @Override
    public UnitedRecord convert() {
        return new UnitedRecord(model.first() + model.second() + model.third());
    }
}
