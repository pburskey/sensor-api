package com.burskey.sensor.domain;

import com.burskey.sensor.domain.DoubleStatistics;
import com.burskey.sensor.domain.SensorEvent;
import com.burskey.sensor.domain.SensorMonitorEvent;
import com.burskey.sensor.domain.SensorMonitorEventItem;

import java.util.*;

public class SensorDistribution
{
    public Double high;
    public Double low;
    public Date dateTime;
    public Number standardDeviation = null;
    public List<Double[]> history = new ArrayList<>();
    public SensorMonitorEvent event;
    public List<SensorEvent> events = new ArrayList<>();


    public void add(SensorMonitorEvent event)
    {
        List<Double> list = new ArrayList<>();
        if (event != null)
        {
            this.event = event;
            this.dateTime = event.getStop();
            if (event.getItems() != null)
            {
                for(SensorMonitorEventItem anItem : event.getItems())
                {
                    if (anItem != null )
                    {
                        Double aMeasurement = anItem.getMeasurement();
                        if (aMeasurement != null)
                        {
                            list.add(aMeasurement);
                            if (this.high == null || this.high < aMeasurement)
                            {
                                this.high = aMeasurement;
                                this.events.add(SensorEvent.EXCEEDED_HIGH);
                            }

                            if (this.low == null || this.low > aMeasurement)
                            {
                                this.low = aMeasurement;
                                this.events.add(SensorEvent.DECEED_LOW);
                            }

                        }
                    }
                }

            }

        }
        if (list != null && !list.isEmpty())
        {
            Double[] tempArray = list.toArray(new Double[list.size()]);
            this.history.add(tempArray);

            Number[] numbers = tempArray;
            this.standardDeviation = this.standardDeviation(numbers);
        }



    }


    public Number standardDeviation(Number[] numbers)
    {

        Double standardDeviation = null;
        if (numbers != null)
        {


            standardDeviation = DoubleStatistics.computeStandardDeviation(numbers);
        }

        return standardDeviation;
    }


}
