package org.armishra.fraud.service;

import lombok.AllArgsConstructor;
import org.armishra.fraud.entity.FraudCheckHistory;
import org.armishra.fraud.repo.FraudCheckHistoryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckService {

    private final FraudCheckHistoryRepository  fraudCheckHistoryRepository;

    public boolean isFraudulent(Integer customerId){
        //mock logic
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return false;
    }
}
