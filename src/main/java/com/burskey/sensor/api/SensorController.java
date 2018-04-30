package com.burskey.sensor.api;

import com.burskey.sensor.api.payload.SensorEventPayload;
import com.burskey.sensor.domain.SensorDistribution;
import com.burskey.sensor.domain.SensorEvent;
import com.burskey.sensor.domain.SensorMonitorEvent;
import com.burskey.sensor.domain.SensorMonitorEventItem;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SensorController {

    private SensorDistribution distribution = null;

    @RequestMapping(value = "/sensor", method = RequestMethod.POST, headers = "Accept=application/xml, application/json")
    public ResponseEntity<?> greeting(@RequestBody SensorEventPayload eventPayload)
    {
        if (eventPayload != null)
        {
            SensorMonitorEvent event = this.processPayload(eventPayload);
            System.out.println("Start: " + event.getStart());
            System.out.println("Stop: " + event.getStop());
            if (event.getItems() != null)
            {
                for(SensorMonitorEventItem anItem : event.getItems())
                {
                    System.out.println("Measurement: " + anItem.getTimeStamp() + " " + anItem.getMeasurement());
                }
            }
        }

        return new ResponseEntity<String>("groovy", HttpStatus.OK);
    }




    private SensorMonitorEvent processPayload(SensorEventPayload eventPayload)
    {
        SensorMonitorEvent event = new SensorMonitorEvent();
        if (eventPayload != null)
        {
            event.from(eventPayload);

            if (event != null)
            {
                SensorDistribution distribution = this.getDistribution();
                if (distribution == null)
                {
                    this.distribution = new SensorDistribution();
                }
                this.getDistribution().add(event);

                if (this.getDistribution().events !=null && !this.getDistribution().events.isEmpty())
                {
                    for(SensorEvent detailEvent: this.getDistribution().events)
                    {
                        System.out.println("Detected Event: " + detailEvent);
                    }
                }


            }

        }



        return event;
    }


    public SensorDistribution getDistribution()
    {
        return distribution;
    }
}
