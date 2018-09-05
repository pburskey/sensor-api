package com.burskey.sensor.domain;

import com.burskey.sensor.domain.SensorMonitorEvent;

public interface SensorMonitorDAO {

    public SensorMonitorEvent save(SensorMonitorEvent event);


    public SensorMonitorEventItem[] getLastNEvents(int i);

    public SensorMonitorEvent getLastEvent();

}
