package com.example.springmvc.policy;

import com.example.springmvc.model.output.UnitedRecord;

@FunctionalInterface
public interface ConvertPolicy<T> {

    UnitedRecord convert(T model);

}
