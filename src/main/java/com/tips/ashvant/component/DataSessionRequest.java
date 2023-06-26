package com.tips.ashvant.component;

public class DataSessionRequest {

    private String consentId;
    private DataRange dataRange;
    private String format;

    public DataSessionRequest() {
    }

    public DataSessionRequest(String consentId, DataRange dataRange, String format) {
        this.consentId = consentId;
        this.dataRange = dataRange;
        this.format = format;
    }

    public String getConsentId() {
        return consentId;
    }

    public void setConsentId(String consentId) {
        this.consentId = consentId;
    }

    public DataRange getDataRange() {
        return dataRange;
    }

    public void setDataRange(DataRange dataRange) {
        this.dataRange = dataRange;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
