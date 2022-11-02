package com.example.infrastructure.proxy;

import com.example.domain.service.ChargeResultDTO;
import com.example.domain.service.ChargeService;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ChargeServiceProxy implements ChargeService {
    private final HostAppProxy hostAppProxy;

    public ChargeServiceProxy(HostAppProxy hostAppProxy) {
        this.hostAppProxy = hostAppProxy;
    }

    @Override
    public ChargeResultDTO charge() {
        ResponseEntity<String> chargeResponse = this.hostAppProxy.charge();
        if (chargeResponse.getStatusCode().is2xxSuccessful()) {
            return new ChargeResultDTO(true);
        } else {
            JSONObject jsonObject = new JSONObject(chargeResponse.getBody());
            return new ChargeResultDTO(false, jsonObject.getString("error"));
        }
    }
}
