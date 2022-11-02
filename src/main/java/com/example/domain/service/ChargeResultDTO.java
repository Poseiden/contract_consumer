package com.example.domain.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChargeResultDTO {
    private boolean success;
    private String errorReason;

    public ChargeResultDTO(boolean success) {
        this.success = success;
    }
}
