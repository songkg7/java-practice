package com.example.springmvc.controller;

import com.example.springmvc.model.input.AlphaRecord;
import com.example.springmvc.model.input.BetaRecord;
import com.example.springmvc.model.input.OmegaRecord;
import com.example.springmvc.model.output.UnitedRecord;
import com.example.springmvc.policy.AlphaConverter;
import com.example.springmvc.policy.BetaConverter;
import com.example.springmvc.policy.OmegaConverter;
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
    @PostMapping("/alpha")
    public Mono<UnitedRecord> sampleRecord(AlphaRecord model) {
        log.info("model: {}", model);
        return companyService.getRecordMono(new AlphaConverter(model));
    }

    // @RequestBody
    @PostMapping("/beta")
    public Mono<UnitedRecord> sampleRecord(@RequestBody BetaRecord model) {
        log.info("model: {}", model);
        return companyService.getRecordMono(new BetaConverter(model));
    }

    @PostMapping("/omega")
    public Mono<UnitedRecord> getRecord(@RequestBody OmegaRecord model) {
        log.info("model: {}", model);
        return companyService.getRecordMono(new OmegaConverter(model));
    }
}
