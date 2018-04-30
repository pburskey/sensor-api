package com.burskey.sensor.domain;

import com.burskey.sensor.api.payload.SensorEventItemPayload;
import com.burskey.sensor.api.payload.SensorEventPayload;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SensorMonitorEvent {

    private Date start;
    private Date stop;
    private SensorMonitorEventItem[] items;

    public SensorMonitorEvent() {
    }


    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getStop() {
        return stop;
    }

    public void setStop(Date stop) {
        this.stop = stop;
    }

    public void setStop(String aString) {
        this.stop = stop;
    }


    public SensorMonitorEventItem[] getItems() {
        return items;
    }

    public void setItems(SensorMonitorEventItem[] items) {
        this.items = items;
    }


    public SensorMonitorEvent from(SensorEventPayload eventPayload) {

        if (eventPayload != null) {
            try {
                this.setStart(ParseTimestamp.parse(eventPayload.getStart()));


            } catch (ParseException e) {
//                e.printStackTrace();
                System.out.println(e.getMessage());
            }

            try {
                this.setStop(ParseTimestamp.parse(eventPayload.getStop()));
            } catch (ParseException e) {
//                e.printStackTrace();
                System.out.println(e.getMessage());
            }

            if (eventPayload.getItems() != null) {
                List<SensorMonitorEventItem> list = new ArrayList<>();
                for (SensorEventItemPayload anItem : eventPayload.getItems()) {
                    SensorMonitorEventItem eventItem = new SensorMonitorEventItem();

                    list.add(eventItem.from(anItem));
                }

                if (list != null && !list.isEmpty()) {
                    this.setItems(list.toArray(new SensorMonitorEventItem[list.size()]));
                }

            }
        }
        return this;
    }


}
