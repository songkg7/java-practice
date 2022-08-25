package com.example.springmvc.policy;

import com.example.springmvc.model.input.AlphaRecord;
import com.example.springmvc.model.output.UnitedRecord;

public class AlphaPolicy implements ConvertPolicy<AlphaRecord> {

    @Override
    public UnitedRecord convert(AlphaRecord model) {
        return new UnitedRecord(model.first() + model.second());
    }
}
