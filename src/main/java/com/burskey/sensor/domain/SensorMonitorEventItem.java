package com.burskey.sensor.domain;

import com.burskey.sensor.api.payload.SensorEventItemPayload;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

public class SensorMonitorEventItem {
    private Date timeStamp = null;
    private Double measurement = null;
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

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }


    public void setMeasurement(BigDecimal measurement) {
        if (measurement != null) {
            this.measurement = measurement.doubleValue();
        }

    }

    public Double getMeasurement() {
        return measurement;
    }

    public void setMeasurement(Double measurement) {
        this.measurement = measurement;
    }


    public void setMeasurement(String measurement) {
        BigDecimal bd = null;
        if (measurement != null && measurement.length() > 0) {
            bd = new BigDecimal(measurement);

        }
        this.setMeasurement(bd);

    }


    public SensorMonitorEventItem from(SensorEventItemPayload itemPayload) {

        if (itemPayload != null) {
            try {
                this.setTimeStamp(ParseTimestamp.parse(itemPayload.getTimeStamp()));
            } catch (ParseException e) {
//                e.printStackTrace();
                System.out.println(e.getMessage());
            }

            this.setMeasurement(itemPayload.getMeasurement());


        }
        return this;
    }


}
