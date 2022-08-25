package com.example.springmvc.service;

import com.example.springmvc.converter.RecordConverter;
import com.example.springmvc.model.output.UnitedRecord;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CompanyService {

    public Mono<UnitedRecord> getRecordMono(RecordConverter converter) {
        return Mono.just(converter.convert());
    }
}
