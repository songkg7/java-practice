package com.example.springmvc.controller;

import com.example.springmvc.model.ARecord;
import com.example.springmvc.model.BRecord;
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

    // @RequestParam
    @PostMapping("/a")
    public Mono<ARecord> sampleRecord(ARecord model) {
        log.info("model: {}", model);
        return companyService.getARecordMono(model);
    }

    // @RequestBody
    @PostMapping("/b")
    public Mono<BRecord> sampleRecord(@RequestBody BRecord model) {
        log.info("model: {}", model);
        return companyService.getBRecordMono(model);
    }
}
