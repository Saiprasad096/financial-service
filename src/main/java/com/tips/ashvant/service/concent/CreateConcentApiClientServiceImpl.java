package com.tips.ashvant.service.concent;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class CreateConcentApiClientServiceImpl {

    private static final Log LOG = LogFactory.getLog(CreateConcentApiClientServiceImpl.class);

    /**
     * Processes the consent by making a POST request to the consent API with the
     * provided consent payload.
     *
     * @param consentPayload the consent payload as a string
     * @return the response body received from the API, or null if an error occurs
     */

    public String processConsent(String consentPayload) {

        String apiUrl = "https://api.setu.co/consents";

        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(apiUrl);

        httpPost.setHeader(HttpHeaders.CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
        httpPost.setHeader(HttpHeaders.AUTHORIZATION, "Token");

        StringEntity requestEntity = new StringEntity(consentPayload, ContentType.APPLICATION_JSON);
        httpPost.setEntity(requestEntity);

        try {
            CloseableHttpResponse response = httpClient.execute(httpPost);

            String responseBody = EntityUtils.toString(response.getEntity());

            LOG.info("Response Code: " + response.getStatusLine().getStatusCode());
            LOG.info("Response Body: " + responseBody);

            return responseBody;

        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                LOG.error(e.getMessage(), e);
            }
        }
        return null;
    }
}
