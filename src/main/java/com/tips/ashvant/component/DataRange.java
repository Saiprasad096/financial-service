package com.tips.ashvant.component;

/**
 * Represents a data range with a start and end point.
 */
public class DataRange {

    private String from;
    private String to;

    /**
     * Default constructor for the DataRange class.
     */
    public DataRange() {
    }

    /**
     * Constructs a DataRange object with the specified start and end points.
     *
     * @param from the start point of the data range
     * @param to   the end point of the data range
     */
    public DataRange(String from, String to) {
        this.from = from;
        this.to = to;
    }

    /**
     * Returns the start point of the data range.
     *
     * @return the start point
     */
    public String getFrom() {
        return from;
    }

    /**
     * Sets the start point of the data range.
     *
     * @param from the start point to set
     */
    public void setFrom(String from) {
        this.from = from;
    }

    /**
     * Returns the end point of the data range.
     *
     * @return the end point
     */
    public String getTo() {
        return to;
    }

    /**
     * Sets the end point of the data range.
     *
     * @param to the end point to set
     */
    public void setTo(String to) {
        this.to = to;
    }
}
