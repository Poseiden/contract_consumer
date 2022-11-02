package com.example.domain.service;

import org.springframework.stereotype.Service;

@Service
public interface ChargeService {
    ChargeResultDTO charge();
}
