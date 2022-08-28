package org.armishra.fraud.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.armishra.clients.dto.fraud.FraudCheckResponse;
import org.armishra.fraud.service.FraudCheckService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@AllArgsConstructor
@RequestMapping("/api/v1/fraudCheck")
public class FraudController {

    private final FraudCheckService fraudCheckService;



    @GetMapping(path = "/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId){
        log.info("Fraud check request for customer id {}",customerId);
        boolean isFraudulentCustomer = fraudCheckService.isFraudulent(customerId);
        return new FraudCheckResponse(isFraudulentCustomer);
    }
}
