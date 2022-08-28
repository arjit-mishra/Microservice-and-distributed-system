package org.armishra.clients.fraud;

import org.armishra.clients.dto.fraud.FraudCheckResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("fraud")
@RequestMapping("/api/v1/fraudCheck")
public interface FraudClient {

    @GetMapping(path = "/{customerId}")
    FraudCheckResponse isFraudster(@PathVariable("customerId") Integer customerId);
}
