package com.tips.ashvant.service.concent;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class GetConcentStatusApiServiceImpl {

    private static final Log LOG = LogFactory.getLog(GetConcentStatusApiServiceImpl.class);

    /**
     * Retrieves the status of a consent based on the consent ID by making a GET
     * request to the consent API.
     *
     * @param consentId the ID of the consent
     * @return a ResponseEntity containing the response body received from the API
     *         if successful, or a response with HTTP status code 500 if an error
     *         occurs
     */

    public ResponseEntity<String> statusConsent(String consentId) {

        String apiUrl = "https://api.setu.co/consents/{id}";

        String url = apiUrl.replace("{id}", consentId);

        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet(url);

        httpGet.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        httpGet.setHeader(HttpHeaders.AUTHORIZATION, "Token");

        try {
            HttpResponse response = httpClient.execute(httpGet);

            String responseBody = EntityUtils.toString(response.getEntity());

            return ResponseEntity.ok(responseBody);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                LOG.error(e.getMessage(), e);
            }
        }
    }
}
