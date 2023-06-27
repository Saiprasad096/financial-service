package com.tips.ashvant.service.datasession;

import java.io.IOException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

public class FetchDataSessionApiServiceImpl {

    private static final Log LOG = LogFactory.getLog(FetchDataSessionApiServiceImpl.class);

    /**
     * Fetches the financial institution data associated with the specified session
     * ID by making a GET request to the sessions API.
     *
     * @param sessionId the ID of the data session
     * @return the fetched financial institution data as a string if the request is
     *         successful, or null if an error occurs or the response code is not
     *         200
     */

    public String fetchFIData(String sessionId) {
        String apiUrl = "https://api.setu.co/sessions/{id}";
        String url = apiUrl.replace("{id}", sessionId);

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);

        httpGet.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        httpGet.setHeader(HttpHeaders.AUTHORIZATION, "Token");

        try {
            HttpResponse response = httpClient.execute(httpGet);

            if (response.getStatusLine().getStatusCode() == HttpStatus.OK.value()) {
                String responseBody = EntityUtils.toString(response.getEntity());
                return responseBody;
            } else {
                return null;
            }

        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
            return null;
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                LOG.error(e.getMessage(), e);
            }
        }

    }
}
