package com.example.springmvc.policy;

import com.example.springmvc.model.output.UnitedRecord;

@FunctionalInterface
public interface RecordConverter {

    UnitedRecord convert();

}
