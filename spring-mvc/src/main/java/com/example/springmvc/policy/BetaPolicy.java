package com.example.springmvc.policy;

import com.example.springmvc.model.input.BetaRecord;
import com.example.springmvc.model.output.UnitedRecord;

public class BetaPolicy implements ConvertPolicy<BetaRecord> {
    @Override
    public UnitedRecord convert(BetaRecord model) {
        return new UnitedRecord(model.first() + model.second() + model.third());
    }
}
