package com.example.springmvc.controller;

import com.example.springmvc.model.input.AlphaRecord;
import com.example.springmvc.model.input.BetaRecord;
import com.example.springmvc.model.input.OmegaRecord;
import com.example.springmvc.model.output.UnitedRecord;
import com.example.springmvc.policy.OmegaPolicy;
import com.example.springmvc.service.CompanyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping
    public String home() {
        return "home";
    }

    // @ModelAttribute
    @PostMapping("/a")
    public Mono<AlphaRecord> sampleRecord(AlphaRecord model) {
        log.info("model: {}", model);
        return companyService.getARecordMono(model);
    }

    // @RequestBody
    @PostMapping("/b")
    public Mono<BetaRecord> sampleRecord(@RequestBody BetaRecord model) {
        log.info("model: {}", model);
        return companyService.getBRecordMono(model);
    }

    @PostMapping("/c")
    public Mono<UnitedRecord> getRecord(@RequestBody OmegaRecord model) {
        log.info("model: {}", model);
        OmegaPolicy omegaPolicy = new OmegaPolicy();
        UnitedRecord record = omegaPolicy.convert(model);
        return companyService.getRecordMono(record);
    }
}
