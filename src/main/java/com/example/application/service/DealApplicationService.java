package com.example.application.service;

import com.example.application.dto.DealRequest;
import com.example.domain.common.exception.BusinessException;
import com.example.domain.service.ChargeResultDTO;
import com.example.domain.service.ChargeService;
import org.springframework.stereotype.Service;

import static com.example.domain.common.exception.ErrorKey.INVALID_AMOUNT;
import static com.example.domain.common.exception.ErrorKey.INVALID_PARAMS;
import static com.google.common.base.Strings.isNullOrEmpty;

@Service
public class DealApplicationService {
    private final ChargeService chargeService;
    public DealApplicationService(ChargeService chargeService) {
        this.chargeService = chargeService;
    }

    public void deal(DealRequest dealRequest) {
        if (isNullOrEmpty(dealRequest.getUserId())) {
            throw new BusinessException(INVALID_PARAMS);
        }

        if (dealRequest.getAmount() < 100) {
            throw new BusinessException(INVALID_AMOUNT);
        }

        ChargeResultDTO chargeResultDTO = this.chargeService.charge();
    }
}
