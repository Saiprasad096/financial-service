package com.tips.ashvant.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tips.ashvant.service.concent.CreateConcentApiClientServiceImpl;
import com.tips.ashvant.service.concent.GetConcentStatusApiServiceImpl;

@RestController
public class ConcentApiController {

    @PostMapping("/consents")
    public ResponseEntity<String> handleConsentRequest(@RequestBody String consentPayload) {
        CreateConcentApiClientServiceImpl consentApiClient = new CreateConcentApiClientServiceImpl();

        String response = consentApiClient.processConsent(consentPayload);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getConsentStatus(@PathVariable("id") String consentId) {

        GetConcentStatusApiServiceImpl getConcentStatusApiService = new GetConcentStatusApiServiceImpl();
        ResponseEntity<String> response = getConcentStatusApiService.statusConsent(consentId);

        return response;
    }

}
