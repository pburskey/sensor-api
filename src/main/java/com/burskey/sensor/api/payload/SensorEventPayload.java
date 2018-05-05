package com.burskey.sensor.api.payload;

public class SensorEventPayload {

    private Long sensorMonitorEventSkey = null;

    public Long getSensorMonitorEventSkey() {
        return sensorMonitorEventSkey;
    }

    public void setSensorMonitorEventSkey(Long sensorMonitorEventSkey) {
        this.sensorMonitorEventSkey = sensorMonitorEventSkey;
    }

    private String start;
    private String stop;
    private SensorEventItemPayload[] items;

    public SensorEventPayload() {
    }

    public SensorEventPayload(String start, String stop, SensorEventItemPayload[] measurements) {
        this.start = start;
        this.stop = stop;
        this.items = measurements;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public SensorEventItemPayload[] getItems() {
        return items;
    }

    public void setItems(SensorEventItemPayload[] items) {
        this.items = items;
    }


}
