package com.burskey.sensor.api.payload;

import org.springframework.validation.Validator;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class SensorEventItemPayload
{
    private String timeStamp = null;
    private String measurement = null;

    private Long sensorMonitorEventSkey = null;
    private Long sensorMontiorEventItemSkey = null;

    public Long getSensorMonitorEventSkey() {
        return sensorMonitorEventSkey;
    }

    public void setSensorMonitorEventSkey(Long sensorMonitorEventSkey) {
        this.sensorMonitorEventSkey = sensorMonitorEventSkey;
    }

    public Long getSensorMontiorEventItemSkey() {
        return sensorMontiorEventItemSkey;
    }

    public void setSensorMontiorEventItemSkey(Long sensorMontiorEventItemSkey) {
        this.sensorMontiorEventItemSkey = sensorMontiorEventItemSkey;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMeasurement() {
        return measurement;
    }

    public void setMeasurement(String measurement) {
        this.measurement = measurement;
    }


}
