package com.tips.ashvant.component;

/**
 * Represents a data session request containing the consent ID, data range, and
 * format.
 */

public class DataSessionRequest {

    private String consentId;
    private DataRange dataRange;
    private String format;

    /**
     * Default constructor for the DataSessionRequest class.
     */

    public DataSessionRequest() {
    }

    /**
     * Constructs a DataSessionRequest object with the specified consent ID, data
     * range, and format.
     *
     * @param consentId the consent ID associated with the data session
     * @param dataRange the data range for the data session
     * @param format    the format of the data session
     */

    public DataSessionRequest(String consentId, DataRange dataRange, String format) {
        this.consentId = consentId;
        this.dataRange = dataRange;
        this.format = format;
    }

    /**
     * Returns the consent ID associated with the data session.
     *
     * @return the consent ID
     */
    public String getConsentId() {
        return consentId;
    }

    /**
     * Sets the consent ID for the data session.
     *
     * @param consentId the consent ID to set
     */
    public void setConsentId(String consentId) {
        this.consentId = consentId;
    }

    /**
     * Returns the data range for the data session.
     *
     * @return the data range
     */
    public DataRange getDataRange() {
        return dataRange;
    }

    /**
     * Sets the data range for the data session.
     *
     * @param dataRange the data range to set
     */
    public void setDataRange(DataRange dataRange) {
        this.dataRange = dataRange;
    }

    /**
     * Returns the format of the data session.
     *
     * @return the data format
     */
    public String getFormat() {
        return format;
    }

    /**
     * Sets the format of the data session.
     *
     * @param format the data format to set
     */
    public void setFormat(String format) {
        this.format = format;
    }
}