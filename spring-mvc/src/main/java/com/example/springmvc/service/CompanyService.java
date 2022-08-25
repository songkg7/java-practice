package com.example.springmvc.service;

import com.example.springmvc.model.input.AlphaRecord;
import com.example.springmvc.model.input.BetaRecord;
import com.example.springmvc.model.output.UnitedRecord;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CompanyService {

    public Mono<AlphaRecord> getARecordMono(AlphaRecord model) {
        return Mono.just(model);
    }

    public Mono<BetaRecord> getBRecordMono(BetaRecord model) {
        return Mono.just(model);
    }

    public Mono<UnitedRecord> getRecordMono(UnitedRecord model) {
        return Mono.just(model);
    }
}
