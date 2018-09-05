package com.burskey.sensor.api;

import com.burskey.sensor.api.payload.SensorEventItemPayload;
import com.burskey.sensor.api.payload.SensorEventOverviewPayload;
import com.burskey.sensor.api.payload.SensorEventPayload;
import com.burskey.sensor.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class SensorController {



    @Autowired
    DataSource dataSource;

    @Autowired
    SensorMonitorDAO sensorMonitorDAO = null;


    @CrossOrigin(origins = {"http://localhost:3000", "http://www.burskey.com", "www.burskey.com/:1", "http://burskey.com/:1","http://burskey.com"})
    @RequestMapping(
            value = "/sensor/events/last",
            method = RequestMethod.GET,
            headers = "Accept=application/xml, application/json" ,
            produces = "application/json")
    public @ResponseBody SensorEventItemPayload[] getLastNSensorEvents(@RequestParam(value="limit", defaultValue = "5") String limit)
    {
        int aLimit = 5;

        try
        {
            aLimit = Integer.parseInt(limit);
        }
        catch (Exception e)
        {
            aLimit = 5;
        }

        SensorMonitorEventItem[] events = this.getSensorMonitorDAO().getLastNEvents(Integer.parseInt(limit));

        List<SensorEventItemPayload> list = new ArrayList<>();
        for(SensorMonitorEventItem item : events)
        {
            SensorEventItemPayload payload = new SensorEventItemPayload();
            payload.setMeasurement(item.getMeasurement().toString());
            payload.setTimeStamp(ParseTimestamp.from(item.getTimeStamp()));
            payload.setSensorMonitorEventSkey(item.getSensorMonitorEventSkey());
            payload.setSensorMontiorEventItemSkey(item.getSensorMontiorEventItemSkey());
            list.add(payload);
        }

        SensorEventItemPayload[] payloads = null;
        if (list != null && !list.isEmpty())
        {
            payloads = list.toArray(new SensorEventItemPayload[list.size()]);
        }


        return payloads;
//        return new ResponseEntity<List<SensorEventItemPayload>>(list, HttpStatus.OK);

    }



    @CrossOrigin(origins = {"http://localhost:3000", "http://www.burskey.com", "www.burskey.com/:1", "http://burskey.com/:1","http://burskey.com"})
    @RequestMapping(
            value = "/sensor/events/lastevent",
            method = RequestMethod.GET,
            headers = "Accept=application/xml, application/json" ,
            produces = "application/json")
    public @ResponseBody SensorEventItemPayload[] getLastSensorEvent()
    {

        SensorMonitorEvent event = this.getSensorMonitorDAO().getLastEvent();
        SensorMonitorEventItem[] events = event.getItems();


        SensorEventOverviewPayload overviewPayload = new SensorEventOverviewPayload();


        List<SensorEventItemPayload> list = new ArrayList<>();
        for(SensorMonitorEventItem item : events)
        {
            SensorEventItemPayload payload = new SensorEventItemPayload();
            payload.setMeasurement(item.getMeasurement().toString());
            payload.setTimeStamp(ParseTimestamp.from(item.getTimeStamp()));
            payload.setSensorMonitorEventSkey(item.getSensorMonitorEventSkey());
            payload.setSensorMontiorEventItemSkey(item.getSensorMontiorEventItemSkey());
            list.add(payload);
        }

        SensorEventItemPayload[] payloads = null;
        if (list != null && !list.isEmpty())
        {
            payloads = list.toArray(new SensorEventItemPayload[list.size()]);
        }


        return payloads;
//        return new ResponseEntity<List<SensorEventItemPayload>>(list, HttpStatus.OK);

    }





    @RequestMapping(value = "/sensor", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
    public ResponseEntity<?> saveSensor(@RequestBody SensorEventPayload eventPayload)
    {
        if (eventPayload != null)
        {
            List<Double> list = new ArrayList<>();
            SensorMonitorEvent event = this.processPayload(eventPayload);
            System.out.println("Start: " + event.getStart());
            System.out.println("Stop: " + event.getStop());
            if (event.getItems() != null)
            {
                for(SensorMonitorEventItem anItem : event.getItems())
                {
                    list.add(anItem.getMeasurement());
                    System.out.println("Measurement: " + anItem.getTimeStamp() + " " + anItem.getMeasurement());
                }
            }

            PlanarDetermination planarDetermination = new PlanarDetermination(list);
            System.out.println("Planar Determination: " + planarDetermination.getDetermination());

            if (planarDetermination.getDeterminationHistory() != null)
            {
                for(PlanarDetermination.Determination determination : planarDetermination.getDeterminationHistory())
                {
                    System.out.println("Planar Determination History: " + determination);
                }
            }






        }

        return new ResponseEntity<String>("groovy", HttpStatus.OK);
    }





    @RequestMapping(value = "/checkin", method = RequestMethod.GET, headers = "Accept=application/xml, application/json")
    public ResponseEntity<?> checkin()
    {
        System.out.println("check in...");
        return new ResponseEntity<String>("groovy", HttpStatus.OK);
    }



    public SensorMonitorDAO getSensorMonitorDAO() {
        if (this.sensorMonitorDAO == null) {
            throw new UnsupportedOperationException("Sensor monitor dao is required");
        }
        return sensorMonitorDAO;
    }

    private SensorMonitorEvent processPayload(SensorEventPayload eventPayload)
    {
        SensorMonitorEvent event = new SensorMonitorEvent();

        if (eventPayload != null)
        {
            event.from(eventPayload);

            if (event != null)
            {
                this.getSensorMonitorDAO().save(event);
            }

        }



        return event;
    }



}
