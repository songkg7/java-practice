package com.example.springmvc.service;

import com.example.springmvc.model.ARecord;
import com.example.springmvc.model.BRecord;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CompanyService {

    public Mono<ARecord> getARecordMono(ARecord model) {
        return Mono.just(model);
    }

    public Mono<BRecord> getBRecordMono(BRecord model) {
        return Mono.just(model);
    }
}
