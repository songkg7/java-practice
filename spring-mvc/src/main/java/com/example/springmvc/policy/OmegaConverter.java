package com.example.springmvc.policy;

import com.example.springmvc.model.input.OmegaRecord;
import com.example.springmvc.model.output.UnitedRecord;

public class OmegaConverter implements RecordConverter {

    private final OmegaRecord model;

    public OmegaConverter(OmegaRecord model) {
        this.model = model;
    }

    @Override
    public UnitedRecord convert() {
        return new UnitedRecord(model.first() + model.second() + model.third() + model.forth());
    }
}
