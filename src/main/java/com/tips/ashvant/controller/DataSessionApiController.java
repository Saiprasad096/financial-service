package com.tips.ashvant.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tips.ashvant.component.DataSessionRequest;
import com.tips.ashvant.service.datasession.CreateDataSessionApiServiceImpl;
import com.tips.ashvant.service.datasession.FetchDataSessionApiServiceImpl;

@RestController
public class DataSessionApiController {

    @PostMapping("/data-sessions")
    public ResponseEntity<String> createDataSession(@RequestBody DataSessionRequest request) {

        CreateDataSessionApiServiceImpl createDataSession = new CreateDataSessionApiServiceImpl();
        ResponseEntity<String> response = createDataSession.createDataSession(request);

        return response;
    }

    @GetMapping("/data-sessions/{id}")
    public ResponseEntity<String> fetchFIData(@PathVariable("id") String sessionId) {
        FetchDataSessionApiServiceImpl dataSessionService = new FetchDataSessionApiServiceImpl();

        String fiData = dataSessionService.fetchFIData(sessionId);
        if (fiData != null) {
            return ResponseEntity.ok(fiData);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
