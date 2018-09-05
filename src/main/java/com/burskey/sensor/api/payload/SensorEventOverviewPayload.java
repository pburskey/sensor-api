package com.burskey.sensor.api.payload;

public class SensorEventOverviewPayload
{
    public Long measurementCount = null;
    public Long measurementEvents = null;
    public String lastEventDateTime = null;
    public Double rangeFloor = null;
    public Double rangeCeiling = null;
    public String periodStartDateTime = null;
    public String periodEndDateTime = null;
    public String[] periodDispositions = null;


    public Long getMeasurementCount() {
        return measurementCount;
    }

    public void setMeasurementCount(Long measurementCount) {
        this.measurementCount = measurementCount;
    }

    public Long getMeasurementEvents() {
        return measurementEvents;
    }

    public void setMeasurementEvents(Long measurementEvents) {
        this.measurementEvents = measurementEvents;
    }

    public String getLastEventDateTime() {
        return lastEventDateTime;
    }

    public void setLastEventDateTime(String lastEventDateTime) {
        this.lastEventDateTime = lastEventDateTime;
    }

    public Double getRangeFloor() {
        return rangeFloor;
    }

    public void setRangeFloor(Double rangeFloor) {
        this.rangeFloor = rangeFloor;
    }

    public Double getRangeCeiling() {
        return rangeCeiling;
    }

    public void setRangeCeiling(Double rangeCeiling) {
        this.rangeCeiling = rangeCeiling;
    }

    public String getPeriodStartDateTime() {
        return periodStartDateTime;
    }

    public void setPeriodStartDateTime(String periodStartDateTime) {
        this.periodStartDateTime = periodStartDateTime;
    }

    public String getPeriodEndDateTime() {
        return periodEndDateTime;
    }

    public void setPeriodEndDateTime(String periodEndDateTime) {
        this.periodEndDateTime = periodEndDateTime;
    }

    public String[] getPeriodDispositions() {
        return periodDispositions;
    }

    public void setPeriodDispositions(String[] periodDispositions) {
        this.periodDispositions = periodDispositions;
    }
}
