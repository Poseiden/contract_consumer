package com.example.presentation.controller;

import com.example.application.dto.DealRequest;
import com.example.application.service.DealApplicationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DealController {

    private final DealApplicationService dealApplicationService;

    public DealController(DealApplicationService dealApplicationService) {
        this.dealApplicationService = dealApplicationService;
    }

    @PostMapping("/deal")
    public void deal(@RequestBody DealRequest dealRequest) {
        this.dealApplicationService.deal(dealRequest);
    }

}
