package com.example.presentation.controller;

import com.example.application.service.DealApplicationService;
import com.example.base.APIBaseTest;
import com.example.infrastructure.proxy.HostAppProxy;
import org.json.JSONObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;

@AutoConfigureStubRunner(
        ids = {"ojk:contract_provider-stubs:8099"}
        , stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class DealApplicationServiceTest extends APIBaseTest {
    @Autowired
    private DealApplicationService dealApplicationService;
    @Autowired
    private HostAppProxy hostAppProxy;

    @Test
    public void name() {
        RestTemplate restTemplate = new RestTemplate();

        JSONObject jsonObjectl = new JSONObject();
        jsonObjectl.put("userId", "john");
        jsonObjectl.put("amount", 100);

        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> httpEntity = new HttpEntity<>(jsonObjectl.toString(), headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange("http://localhost:8099/charge",
                HttpMethod.POST, httpEntity, String.class);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }
}
