package com.tips.ashvant.service.datasession;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.tips.ashvant.component.DataSessionRequest;

public class CreateDataSessionApiServiceImpl {

    public ResponseEntity<String> createDataSession(DataSessionRequest request) {

        String apiUrl = "https://api.setu.co/sessions";

        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(apiUrl);

        httpPost.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
        httpPost.setHeader(HttpHeaders.AUTHORIZATION, "Bearer <YOUR_ACCESS_TOKEN>");

        JSONObject requestObject = new JSONObject();
        requestObject.put("consentId", request.getConsentId());

        JSONObject dataRangeObject = new JSONObject();
        dataRangeObject.put("from", request.getDataRange().getFrom());
        dataRangeObject.put("to", request.getDataRange().getTo());

        requestObject.put("DataRange", dataRangeObject);
        requestObject.put("format", request.getFormat());

        StringEntity requestEntity = new StringEntity(requestObject.toString(), ContentType.APPLICATION_JSON);
        httpPost.setEntity(requestEntity);

        try {

            HttpResponse response = httpClient.execute(httpPost);

            String responseBody = EntityUtils.toString(response.getEntity());

            return ResponseEntity.ok(responseBody);

        } catch (IOException e) {
            e.printStackTrace();

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {

            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
