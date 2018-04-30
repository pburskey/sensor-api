package com.burskey.sensor.api;

import com.burskey.sensor.api.payload.SensorEventItemPayload;
import com.burskey.sensor.domain.SensorMonitorEventItem;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;


public class SensorMonitorEventItemPayloadTest {

    String sampleDate = "2018-04-22_17:03:33";

    @Test
    public void test_1() throws Exception
    {
        SensorEventItemPayload payload = new SensorEventItemPayload();
        assertNotNull(payload);
    }

    @Test
    public void test_time_1() throws Exception
    {
        SensorEventItemPayload payload = new SensorEventItemPayload();
        assertNotNull(payload);
        payload.setTimeStamp(sampleDate);
        assertNotNull(payload.getTimeStamp());
    }

    @Test
    public void test_time_2() throws Exception
    {
        SensorEventItemPayload payload = new SensorEventItemPayload();
        assertNotNull(payload);
        payload.setTimeStamp(sampleDate);
        assertNotNull(payload.getTimeStamp());
    }

    @Test
    public void test_time_3() throws Exception
    {
        SensorEventItemPayload payload = new SensorEventItemPayload();
        assertNotNull(payload);
        payload.setTimeStamp(sampleDate);
        assertNotNull(payload.getTimeStamp());


        SensorMonitorEventItem item = new SensorMonitorEventItem();
        item.from(payload);

        Date date = item.getTimeStamp();
        assertNotNull(date);
    }


    @Test
    public void test_measurement_1() throws Exception
    {
        SensorEventItemPayload payload = new SensorEventItemPayload();
        assertNotNull(payload);
        payload.setMeasurement("1.12");
        assertNotNull(payload.getMeasurement());
    }


    @Test
    public void test_measurement_2() throws Exception
    {
        SensorEventItemPayload payload = new SensorEventItemPayload();
        assertNotNull(payload);
        payload.setMeasurement("1.12");
        assertNotNull(payload.getMeasurement());



        SensorMonitorEventItem item = new SensorMonitorEventItem();
        item.from(payload);


        Double bd = item.getMeasurement();
        assertNotNull(bd);
    }


    @Test
    public void test_measurement_3() throws Exception
    {
        SensorEventItemPayload payload = new SensorEventItemPayload();
        assertNotNull(payload);
        payload.setMeasurement("1.12");
        assertNotNull(payload.getMeasurement());


        SensorMonitorEventItem item = new SensorMonitorEventItem();
        item.from(payload);


        double a = 1.12;
        double b = item.getMeasurement();
        assertEquals(a, b,0);
    }


    @Test
    public void test_measurement_4() throws Exception
    {
        SensorEventItemPayload payload = new SensorEventItemPayload();
        assertNotNull(payload);
        payload.setMeasurement("0.12");
        assertNotNull(payload.getMeasurement());


        SensorMonitorEventItem item = new SensorMonitorEventItem();
        item.from(payload);


        double a = 0.12;
        double b = item.getMeasurement();
        assertEquals(a, b,0);
    }



}