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

    /**
     * Creates a data session based on the provided data session request.
     *
     * @param request the data session request object
     * @return a ResponseEntity containing the response message and HTTP status code
     */

    @PostMapping("/data-sessions")
    public ResponseEntity<String> createDataSession(@RequestBody DataSessionRequest request) {

        CreateDataSessionApiServiceImpl createDataSession = new CreateDataSessionApiServiceImpl();
        ResponseEntity<String> response = createDataSession.createDataSession(request);

        return response;
    }

    /**
     * Fetches the Financial Institution (FI) data for a specific data session.
     *
     * @param sessionId the ID of the data session
     * @return a ResponseEntity containing the FI data or a response with HTTP
     *         status code 404 if the data is not found
     */

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
