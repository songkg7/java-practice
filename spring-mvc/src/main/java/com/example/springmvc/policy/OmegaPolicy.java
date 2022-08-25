package com.example.springmvc.policy;

import com.example.springmvc.model.input.OmegaRecord;
import com.example.springmvc.model.output.UnitedRecord;

public class OmegaPolicy implements ConvertPolicy<OmegaRecord> {
    @Override
    public UnitedRecord convert(OmegaRecord model) {
        return new UnitedRecord(model.first() + model.second() + model.third() + model.forth());
    }
}
